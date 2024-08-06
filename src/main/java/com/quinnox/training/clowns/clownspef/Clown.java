package com.quinnox.training.clowns.clownspef;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.quinnox.training.clowns.lionspef.Lion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table
public class Clown {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clown_id")
    private Long id;
    private Integer yrsofservice;
    private String name;
    private String skill;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clown")
    @JsonManagedReference
    private List<Lion> lions;

	public Clown() {

    }

    public Clown(Integer yrsofservice, String name, String skill) {
        this.yrsofservice = yrsofservice;
        this.name = name;
        this.skill = skill;
    }

    public Clown(Long id, Integer yrsofservice, String name, String skill) {
        this.id = id;
        this.yrsofservice = yrsofservice;
        this.name = name;
        this.skill = skill;
    }
    
    public Clown(Long id, Integer yrsofservice, String name, String skill, List<Lion> lions) {
		this.id = id;
		this.yrsofservice = yrsofservice;
		this.name = name;
		this.skill = skill;
		this.lions = lions;
	}

	public List<Lion> getLions() {
		return lions;
	}

	public void addLion(Lion lion) {
		this.lions.add(lion);
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYrsofservice() {
        return yrsofservice;
    }

    public void setYrsofservice(Integer yrsofservice) {
        this.yrsofservice = yrsofservice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

	@Override
	public String toString() {
		return "Clown [id=" + id + ", yrsofservice=" + yrsofservice + ", name=" + name + ", skill=" + skill;
		/*+ ", lions="
				+ lions + "]";*/
	}
    
}
