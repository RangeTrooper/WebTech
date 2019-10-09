package com.skor.alex.lab1.FileWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
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
					substrings=lines.get(i).split("\\|");
					Periodical temp=new Periodical();
					temp.name=substrings[0];
					temp.theme=substrings[1];
					temp.issue=Integer.parseInt(substrings[2]);
					temp.tags=substrings[3];
					temp.price=Float.parseFloat(substrings[4]);
					periodicals.add(temp);
				}
			}
			catch(IOException e) {
				System.out.println("There's no such file or directory!");
			}
			
		}
		return periodicals;
	}
	
	public boolean WriteDataInFile(String newData) {
		File file=new File("E:\\Лабы_5сем\\ВТ\\lab1","data.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch(IOException e) {
				System.out.println("File wasn't created. An error occured");
			}
		}
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
		return true;
	}
	
	public void WriteEditedData(Periodical prev,Periodical curr) {
		File file=new File("E:\\Лабы_5сем\\ВТ\\lab1","data.txt");
		String searchWord=prev.name+"|"+prev.theme+"|"+prev.issue+"|"+prev.tags+"|"+prev.price;
		String changeWord=prev.name+"|"+prev.theme+"|"+prev.issue+"|"+prev.tags+"|"+prev.price;
		if (file.exists()) {
			StringBuilder sb = new StringBuilder();
		
		    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		        String strLine;
		        while ((strLine = br.readLine()) != null) {
		            sb.append(strLine.replace(searchWord, changeWord)).append(System.getProperty("line.separator"));
		        }
		        FileWriter fileWriter = new FileWriter(file);
		        fileWriter.write(sb.toString());
		    } catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("An internal error occured");
			}
		}
		else {
			System.out.println("An error occured.");
		}
	}
	
	private int GetLinesInFile() {
		File file=new File("E:\\Лабы_5сем\\ВТ\\lab1","data.txt");
		int linesCount = 0; 
		try {
			final LineNumberReader lnr = new LineNumberReader( new FileReader(file)); 
			
			while(null != lnr.readLine()) { 
				linesCount++;
			}
		}catch(IOException ioe) {
			System.out.println("An internal error occured");
		}
		return linesCount;
	}
}
// можно добавить хеширование файлов 