package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Tags")
public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tagid;
	
	@Column(name = "Tagname")
	private String tagname;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "Tags")
		  @JsonIgnore
		  private Set<Newtutorial> Newtutorials = new HashSet<>();

	public Tags() {
		super();
	}

	public int getTagid() {
		return tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public Set<Newtutorial> getNewtutorials() {
		return Newtutorials;
	}

	public void setNewtutorials(Set<Newtutorial> newtutorials) {
		Newtutorials = newtutorials;
	}
	
}
