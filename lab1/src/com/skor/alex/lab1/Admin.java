package com.skor.alex.lab1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import com.skor.alex.lab1.periodicals.Periodical;
import com.skor.alex.lab1.Controller.*;

public class Admin {
	
	public Admin() {
		Controller controller=new Controller();
		while(Start())
		{			
		}
	}
	
	private boolean Start() {
			ShowOptions();
			Scanner in=new Scanner(System.in);
			int answer=in.nextInt();
			switch (answer) {
			case 1:
				Controller.ShowRecentSubscribers();
				break;
			case 2:
				break;
			case 3:
				Controller.AddItem();
				break;
			case 4:
				Controller.EditItem();
				break;
			case 5:
				Controller.DeleteItem();
				break;
			case 6:
				Controller.ShowItem();
				break;
			case 0:
				return false;
			}
			return true;
	}
	
	private void ShowOptions() {
		System.out.println("1: Show recent subscribers");
		System.out.println("2: Show 20 first issues");
		System.out.println("3: Add new item");
		System.out.println("4: Edit item");
		System.out.println("5: Delete item");
		System.out.println("6: Show item info");
		System.out.println("Other character: Exit");
	}
}
