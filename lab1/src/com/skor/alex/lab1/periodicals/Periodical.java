package com.skor.alex.lab1.periodicals;

import java.io.Serializable;
import java.util.ArrayList;

public class Periodical implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String theme;
	public int issue;
	public ArrayList<String> tags;
	public float price;
	
	private int myCatalogueNumber;
	
	
}
