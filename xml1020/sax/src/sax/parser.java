package sax;


import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class parser {

   public static void main(String[] args) {

      try {
         File inputFile = new File("input.txt");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}

class UserHandler extends DefaultHandler {

   boolean bnev = false;
   boolean bkor = false;
   boolean bvaros = false;


   @Override
   public void startElement(
      String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
      
      if (qName.equalsIgnoreCase("szemely")) {
         String id = attributes.getValue("id");
         System.out.println("id : " + id);
      } else if (qName.equalsIgnoreCase("nev")) {
         bnev = true;
      } else if (qName.equalsIgnoreCase("kor")) {
         bkor = true;
      } else if (qName.equalsIgnoreCase("varos")) {
         bvaros = true;
      }

   }

   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
      
      if (qName.equalsIgnoreCase("szemely")) {
         System.out.println("End Element :" + qName);
      }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {

      if (bnev) {
         System.out.println("nev: " + new String(ch, start, length));
         bnev = false;
      } else if (bkor) {
         System.out.println("kor: " + new String(ch, start, length));
         bkor = false;
      } else if (bvaros) {
         System.out.println("varos: " + new String(ch, start, length));
         bvaros = false;
      }
   }
}
