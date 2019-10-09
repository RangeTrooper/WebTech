package com.skor.alex.lab1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static com.skor.alex.lab1.FileWork.FileParser.*;

import com.skor.alex.lab1.FileWork.FileParser;
import com.skor.alex.lab1.periodicals.Periodical;

public class Controller {

	ArrayList<Periodical> periodicals=new ArrayList<Periodical>();
	private FileParser parser;
	
	public Controller() {
		this.parser=new FileParser();
		this.periodicals=parser.GetDataFromFile();
	}
	
	public void DeleteItem() {
		
	}
	//добавить проверку на заполненность листа
	public void AddItem() {
		
		String newData="";
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name of the periodical");
		newData=newData+scanner.nextLine()+"|";
		System.out.println("Enter the theme of the periodical");
		newData=newData+scanner.nextLine()+"|";
		System.out.println("Enter it''s issue");
		newData=newData+scanner.nextLine()+"|";
		System.out.println("Enter tags through comma");
		newData=newData+scanner.nextLine()+"|";
		System.out.println("Enter issue's price");
		newData=newData+scanner.nextLine()+System.getProperty("line.separator");
		parser.WriteDataInFile(newData);
	}
	
	public ArrayList <Periodical> SearchItem(String name, int issue){
		return new ArrayList <Periodical> ();
	}
	
	public void EditItem() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name of the periodical");
		String name=scanner.nextLine();
		System.out.println("Enter the issue of this periodical");
		int issue=Integer.parseInt(scanner.nextLine());
		Periodical curr=new Periodical();
		curr=SearchItem(name,issue).get(0);
		System.out.println(curr.name+"   "+curr.name+"   "+curr.price+"   "+curr.theme+"   ");
		System.out.println("Down here will be shown fields to be edited. If editing isn't necessary, tap Enter");
		System.out.println("Enter new title");
		Periodical temp=new Periodical();
		temp.name=scanner.nextLine();
		if (temp.name.length()<0)
			temp.name=curr.name;
		System.out.println("Enter new issue");
		temp.issue=scanner.nextInt();
		if (temp.issue<=0)
			temp.issue=curr.issue;
		System.out.println("Enter new tags");
		temp.tags=scanner.nextLine();
		if (temp.tags.length()<0){
			temp.tags=curr.tags;
		}
		System.out.println("Enter new price");
		temp.price=scanner.nextFloat();
		if (temp.price<=0)
			temp.price=curr.price;
		parser.WriteEditedData(curr,temp);
	}
	
	public void ShowAllItems() {
		Periodical temp=new Periodical();
		for(int i=0;i<periodicals.size();i++) {
			temp=periodicals.get(i);
			System.out.println(temp.name+" "+temp.name+" "+temp.price+" "+temp.theme+" ");
		}
	}
	
	public void ShowRecentSubscribers() {
		
	}
	
}
