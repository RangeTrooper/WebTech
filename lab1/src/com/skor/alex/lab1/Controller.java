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
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name of the periodical");
		String name=scanner.nextLine();
		System.out.println("Enter the issue of this periodical");
		int issue=Integer.parseInt(scanner.nextLine());
		Periodical curr=new Periodical();
		curr=SearchForItem(name,issue);
		periodicals.remove(periodicals.indexOf(curr));
		boolean flag=true;
		for(int i=0;i<periodicals.size();i++) {
			parser.WriteDataInFile(periodicals.get(i).name+"|"+periodicals.get(i).theme+"|"
						+periodicals.get(i).issue+"|"+periodicals.get(i).tags+
						"|"+periodicals.get(i).price+System.getProperty("line.separator"),flag);
			flag=false;
		}
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
		newData=newData+Float.parseFloat(scanner.nextLine())+System.getProperty("line.separator");
		parser.WriteDataInFile(newData,false);
		this.periodicals=parser.GetDataFromFile();
	}
	
	
	
	public void EditItem() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name of the periodical");
		String name=scanner.nextLine();
		System.out.println("Enter the issue of this periodical");
		int issue=Integer.parseInt(scanner.nextLine());
		Periodical curr=new Periodical();
		curr=SearchForItem(name,issue);
		if(curr!=null) {
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
			scanner.nextLine();
			temp.tags=scanner.nextLine();
			if (temp.tags.length()<0){
				temp.tags=curr.tags;
			}
			System.out.println("Enter new price");
			temp.price=scanner.nextFloat();
			if (temp.price<=0)
				temp.price=curr.price;
			System.out.println("Enter new theme");
			scanner.nextLine();
			temp.theme=scanner.nextLine();
			if (temp.theme.length()<=0)
				temp.theme=curr.theme;
			periodicals.set(periodicals.indexOf(curr), temp);
			//parser.WriteEditedData(curr,temp);
			boolean flag=true;
			for(int i=0;i<periodicals.size();i++) {
				parser.WriteDataInFile(periodicals.get(i).name+"|"+periodicals.get(i).theme+"|"
							+periodicals.get(i).issue+"|"+periodicals.get(i).tags+
							"|"+periodicals.get(i).price+System.getProperty("line.separator"),flag);
				flag=false;
			}
			this.periodicals=parser.GetDataFromFile();
		}else {
			System.out.println("There's no such element in the list!");
		}
		
	}
	
	private Periodical SearchForItem(String name, int issue) {
		for (int i=0;i<periodicals.size();i++) {
			if ((periodicals.get(i).name.equals(name))&&(periodicals.get(i).issue==issue))
			//if ((periodicals.get(i).name==name))
				return periodicals.get(i);
		}
		return null;
	}

	public void ShowAllItems() {
		Periodical temp=new Periodical();
		for(int i=0;i<periodicals.size();i++) {
			temp=periodicals.get(i);
			System.out.println((i+1)+temp.name+" "+temp.theme+" "+temp.issue+" "+temp.tags+" "+temp.price+" ");
		}
	}
	
	public void ShowRecentSubscribers() {
		
	}
	
}
