package com.skor.alex.epamlabs;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.skor.alex.epamlabs.Periodical;

//import static com.sun.java.accessibility.util.EventID.ITEM;

public class XMLParser {

    private final String CATEGORY="category";
    private final String NAME="name";
    private final String TYPE="type";
    private final String ISSUE="issue";
    private final String TAGS="tags";
    private final String PRICE="price";
    private final String ID="ID";
    private final String ITEM="info";

    private final String path="";

    public List<Periodical> ParseXML(String path){
        List<Periodical> items=new ArrayList<Periodical>() ;
        XMLInputFactory inputFactory=XMLInputFactory.newInstance();
        try {
            InputStream in = new FileInputStream(path);
            XMLEventReader eventReader=inputFactory.createXMLEventReader(in);
            Periodical item=null;
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String temp=startElement.getName().getLocalPart();
                    if (startElement.getName().getLocalPart().equals(ITEM)) {
                        item = new Periodical();
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(CATEGORY)) {
                                item.setCategory(attribute.getValue());
                            }
                        }
                        if(item.getCategory()==null)
                            item.setCategory("none");
                    }
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(NAME)) {
                            event = eventReader.nextEvent();
                            item.setName(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TYPE)) {
                        event = eventReader.nextEvent();
                        item.setType(event.asCharacters().getData());
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(ISSUE)) {
                        event = eventReader.nextEvent();
                        item.setIssue(Integer.parseInt(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TAGS)) {
                        event = eventReader.nextEvent();
                        item.setTags(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(PRICE)) {
                        event = eventReader.nextEvent();
                        item.setPrice(Float.parseFloat(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(ID)) {
                        event = eventReader.nextEvent();
                        item.setID(Integer.parseInt(event.asCharacters().getData()));
                        continue;
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(ITEM)) {
                        items.add(item);
                    }
                }
            }
        }catch(IOException e){

        }catch(XMLStreamException e){

        }
        return items;
    }


}
