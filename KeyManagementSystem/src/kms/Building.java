package kms;

import java.util.ArrayList;

public class Building {
	
	//We will load all buildings into this ArrayList from the text
	//file and add any new ones to it. We will also write this into
	//the text file when saving.
	private ArrayList<Building> buildings = new ArrayList<>();
	private String name;
	private String code;
	
	public Building(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	//Code must be only 2 digits
	public String getCode() {
		
		if (code.matches("[0-9]+") == false) {
			return "Building code must only contain digits";
		}
		else if (code.length() != 2) {
			return "Building code must be exactly 2 digits";
		}
		return code;
	}
	
}
