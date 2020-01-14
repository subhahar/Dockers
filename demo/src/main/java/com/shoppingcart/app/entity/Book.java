package com.shoppingcart.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
@PrimaryKeyJoinColumn(name = "productId")
public class Book extends Product {

	private static final long serialVersionUID = 1L;
	@Column(name = "genre")
	private String genre;
	@Column(name = "authour")
	private String authour;
	@Column(name = "publications")
	private String publications;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthour() {
		return authour;
	}

	public void setAuthour(String authour) {
		this.authour = authour;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

}
