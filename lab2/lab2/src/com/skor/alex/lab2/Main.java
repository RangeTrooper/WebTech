package com.skor.alex.lab2;

import java.io.IOException;
import com.skor.alex.lab2.XMLValidator;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(XMLValidator.ValidateXML())
			System.out.println("The XML file is valid");
		else
			System.out.println("The XML file is invalid");
		System.in.read();
	}

}
