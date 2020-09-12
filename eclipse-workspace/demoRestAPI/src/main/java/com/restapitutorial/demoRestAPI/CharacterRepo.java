package com.restapitutorial.demoRestAPI;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepo {
	
	List<Character> characters;
	
	public CharacterRepo() {
		characters = new ArrayList<Character>();
		
		Character ch1 = new Character();
		ch1.setName("2B");
		ch1.setId(1);
		ch1.setType("Android");
		ch1.setAbility("Warrior");
		
		
		Character ch2 = new Character();
		ch2.setName("9S");
		ch2.setId(2);
		ch2.setType("Android");
		ch2.setAbility("Scanner");
		
		characters.add(ch1);
		characters.add(ch2);
	}
	
	public List<Character> getCharacters(){
		return characters;
	}
	
	public Character getCharacter(int id) {
		
		
		for(Character ch : characters) {
			if(ch.getId()==id) {
				return ch;
			}
		}
		
		return new Character();
		
	}
	
	public void create(Character ch) {
		characters.add(ch);
	}

}
