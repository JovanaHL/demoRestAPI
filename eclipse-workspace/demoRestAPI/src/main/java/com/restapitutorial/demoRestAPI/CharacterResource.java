package com.restapitutorial.demoRestAPI;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("characters")
public class CharacterResource {
	
	CharacterRepo repo = new CharacterRepo();
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Character> getCharacters(){
		
		return repo.getCharacters();
	}
	
	@GET
	@Path("character/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Character getCharacter(@PathParam("id") int id) {
		
		System.out.println("getCharacter called..");
		
		
		return repo.getCharacter(id);
	}
	
	@POST
	@Path("character")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Character createCharacter(Character ch) {
		
		System.out.println(ch);
		repo.create(ch);
		
		return ch;
	}
	
	@PUT
	@Path("character")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Character updateCharacter(Character ch) {
		
		System.out.println(ch);
		if(repo.getCharacter(ch.getId()).getId()==0) {
			repo.create(ch);
		}
		repo.update(ch);
		
		return ch;
	}
	
	public Character delete(Character ch) {
		
		
		
		return ch;
		
	}

}
