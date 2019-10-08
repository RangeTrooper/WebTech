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
	
	public Controller() {
		FileParser parser=new FileParser();
		this.periodicals=parser.GetDataFromFile();
	}
	
	public void DeleteItem() {
		
	}
	//добавить проверку на заполненность листа
	public void AddItem() {
		File file=new File("E:\\Лабы_5сем\\ВТ\\lab1","data.txt");
		String newData="";
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch(IOException e) {
				System.out.println("File wasn't created. An error occured");
			}
		}
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
		OutputStream os = null;
        try {
            os = new FileOutputStream(file, true);
            os.write(newData.getBytes(), 0, newData.length());
        } catch (IOException e) {
        	System.out.println("An error occured. Please, try again");
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	public void EditItem() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name of the periodical");
	}
	
	public void ShowItem() {
		Periodical temp=new Periodical();
		for(int i=0;i<periodicals.size();i++) {
			temp=periodicals.get(i);
			System.out.println(temp.name+" "+temp.name+" "+temp.price+" "+temp.theme+" ");
		}
	}
	
	public void ShowRecentSubscribers() {
		
	}
	
}
