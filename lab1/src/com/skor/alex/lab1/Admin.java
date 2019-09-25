package com.skor.alex.lab1;

import java.util.ArrayList;

import com.skor.alex.lab1.periodicals.Periodical;

public class Admin {
	ArrayList<Periodical> periodicals=new ArrayList<Periodical>();
	
	public Admin() {
		Start();
	}
	
	private void Start() {
		boolean flag=true;
		while (flag) {
			ShowOptions();
		}
	}
	
	private void ShowOptions() {
		System.out.println("Show recent subscribers");
		
	}
}
