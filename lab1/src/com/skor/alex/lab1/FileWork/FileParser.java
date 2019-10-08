package com.skor.alex.lab1.FileWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skor.alex.lab1.periodicals.Periodical;

public class FileParser {
	ArrayList<Periodical> periodicals=new ArrayList<Periodical>();
	ArrayList <String> lines=new ArrayList<String> ();
	
	public static void GetDataFromFile() {
		File file=new File("E:\\Лабы_5сем\\ВТ\\lab1","data.txt");
		if (file.exists()) {
			try {
				BufferedReader reader=new BufferedReader(new FileReader(file));
				
			}
			catch(IOException e) {
				System.out.println("There's no such file or directory!");
			}
		}
	}
}
