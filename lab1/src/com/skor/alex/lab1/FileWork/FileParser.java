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
	
	public ArrayList<Periodical> GetDataFromFile() {
		File file=new File("E:\\Лабы_5сем\\ВТ\\lab1","data.txt");
		if (file.exists()) {
			try {
				String line;
				BufferedReader reader=new BufferedReader(new FileReader(file));
				while ((line = reader.readLine()) != null) {
		            lines.add(line);
		            
		        }
				reader.close();
				String [] substrings=new String [6] ;   // 6 элементов на каждое поле объекта издания
				for (int i=0;i<lines.size();i++) {
					substrings=lines.get(i).split("|");
					Periodical temp=new Periodical();
					periodicals.add(temp);
				}
			}
			catch(IOException e) {
				System.out.println("There's no such file or directory!");
			}
			
		}
		return periodicals;
	}
	
	public boolean WriteDataInFile() {
		return true;
	}
}
// можно добавить хеширование файлов 