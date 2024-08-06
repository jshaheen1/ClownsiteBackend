package com.quinnox.training.clowns.lionspef;

import com.quinnox.training.clowns.clownspef.Clown;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
public class Lion {
 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name = "lion_id")
    private Long id;
    private String name;
    private int roarstrength;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="clown_id")
    @JsonBackReference
    private Clown clown;
    
    
    
	public Lion() {

	}
	public Lion(String name, int roarstrength) {
		this.name = name;
		this.roarstrength = roarstrength;
	}
	public Lion(String name, int roarstrength, Clown trainer) {
		this.name = name;
		this.roarstrength = roarstrength;
		this.clown = trainer;
	}
	public Lion(Long id, String name, int roarstrength, Clown trainer) {
		this.id = id;
		this.name = name;
		this.roarstrength = roarstrength;
		this.clown = trainer;
	}
	@Override
	public String toString() {
		return "Lion [id=" + id + ", name=" + name + ", roarstrength=" + roarstrength + ", trainer=" + clown + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoarstrength() {
		return roarstrength;
	}
	public void setRoarstrength(int roarstrength) {
		this.roarstrength = roarstrength;
	}
	public Clown getClown() {
		return clown;
	}
	public void setClown(Clown trainer) {
		this.clown = trainer;
	}
    
    
}
