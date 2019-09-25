package com.skor.alex.lab1;

import java.util.Scanner;

public class MagazineDetector {
	
	public MagazineDetector() {
		ShowAllOptions();
	}
	
	private void ShowAllOptions() {
		boolean flag=true;
		int answer;
		System.out.println("Select the app mode to run in");
		while(flag) {
			System.out.println("1: Administrator mode");
			System.out.println("2: Subscriber mode");
			System.out.println("0: Exit");
			Scanner in = new Scanner(System.in);
			answer=in.nextInt();
			switch(answer) {
			
				case 1: 
					Admin admin=new Admin();
					flag=false;
					break;
				case 2:
					Subscriber subscriber=new Subscriber();
					flag=false;
					break;
				case 3:
					return;
			}
				
		
		}
	}
}
