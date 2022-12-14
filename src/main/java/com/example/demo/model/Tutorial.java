package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "tutorial")
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Books books;
	
	@Column(name = "name")
	private String name;

	public Tutorial() {
		super();
	}

	public int getId() {
		return id;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
