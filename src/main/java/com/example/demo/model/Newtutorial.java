package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Newtutorials")
public class Newtutorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade={
			          CascadeType.PERSIST,
			          CascadeType.MERGE
			      }
	)
	@JoinTable(name = "tutorial_tags",
    joinColumns = { @JoinColumn(name = "id") },
    inverseJoinColumns = { @JoinColumn(name = "tagid") })
    private Set<Tags> Tags = new HashSet<>();

	public Newtutorial() {
		super();
	}

	public int getId() {
		return id;
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

	public Set<Tags> getTags() {
		return Tags;
	}

	public void setTags(Set<Tags> tags) {
		this.Tags = tags;
	}
	
	
	
}
