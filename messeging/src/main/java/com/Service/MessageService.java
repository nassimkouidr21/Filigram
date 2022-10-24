package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Modele.Message;
import com.Repository.MessageRepository;


@Service
public class MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	
	public Message saveMessage(Message message) {
		Message saveMessage = messageRepository.save(message);
		return saveMessage;
	}
	

	
	

}
