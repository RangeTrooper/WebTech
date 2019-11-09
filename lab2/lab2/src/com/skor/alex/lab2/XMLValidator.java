package com.skor.alex.lab2;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.lang.String;

import org.xml.sax.SAXException;

public class XMLValidator {
	public static boolean ValidateXML() {
		try {
			SchemaFactory factory = 
		            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File("E:\\����_5���\\��\\lab2\\lab2\\bin\\com\\skor\\alex\\lab2\\MyShema.xsd"));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File("E:\\����_5���\\��\\lab2\\lab2\\bin\\com\\skor\\alex\\lab2\\MyShema.xml")));
	      } catch (IOException e){
	         return false;
	      } catch (SAXException e) {
			return false;
		}
	      return true;
	}
}
