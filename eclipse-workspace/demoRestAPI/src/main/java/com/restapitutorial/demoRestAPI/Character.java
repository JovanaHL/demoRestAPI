package com.restapitutorial.demoRestAPI;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Character {
	
	private String name;
	private String type;
	private String ability;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
