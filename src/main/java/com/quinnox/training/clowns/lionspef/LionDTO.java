package com.quinnox.training.clowns.lionspef;

public class LionDTO {
    private Long id;
    private String name;
    private int roarstrength;
    private String clownName;
    
    
    
	public LionDTO(Long id, String name, int roarstrength) {
		super();
		this.id = id;
		this.name = name;
		this.roarstrength = roarstrength;
	}


	public LionDTO(Long id, String name, int roarstrength, String clownName) {
		super();
		this.id = id;
		this.name = name;
		this.roarstrength = roarstrength;
		this.clownName = clownName;
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
	public String getClownName() {
		return clownName;
	}
	public void setClownName(String clownName) {
		this.clownName = clownName;
	}
    
    
}
