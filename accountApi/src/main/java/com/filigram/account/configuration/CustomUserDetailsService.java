package com.filigram.account.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filigram.account.Modele.Account;
import com.filigram.account.Modele.InternalRole;
import com.filigram.account.Repository.AccountRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String fullname) throws UsernameNotFoundException {
		Account account = accountRepository.findByFullname(fullname);

		//Use the following line is password are not encrypted in database.
		account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
		
		return new org.springframework.security.core.userdetails.User(
				account.getFullname(), 
				account.getPassword(), 
				getGrantedAuthorities(account.getRole()));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(InternalRole role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//Spring Security automatically prefix role with ROLE_
		//so if the role name in database isn't prefix with ROLE_
		//we have to it
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		return authorities;
	}

}


