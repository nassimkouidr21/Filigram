package com.Modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "posts")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPost;

	private String description;
	

	private int likeCounter;
	@Column(columnDefinition = "boolean default false")
	private Boolean signalPost;
	@Column(columnDefinition = "boolean default false")
	private Boolean signalPostOnce;
	
	@Column(columnDefinition = "text", length = 10000)
	private String image;

	@JsonIgnore
	@OneToMany(targetEntity = Comment.class, mappedBy = "posts")
	private List<Comment> comments = new ArrayList<>();


	public int getLikeCounter() {
		return likeCounter;
	}

	public void setLikeCounter(int likeCounter) {
		this.likeCounter = likeCounter;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSignalPost() {
		return signalPost;
	}

	public void setSignalPost(Boolean signalPost) {
		this.signalPost = signalPost;
	}

	public Boolean getSignalPostOnce() {
		return signalPostOnce;
	}

	public void setSignalPostOnce(Boolean signalPostOnce) {
		this.signalPostOnce = signalPostOnce;
	}

}
