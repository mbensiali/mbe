package xmlSaxParser;

import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Program {

	public static void main(String[] args) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new MyContentHandler());
			System.out.println(" demarrage du parser ");
			reader.parse(new InputSource(new FileInputStream("repertoire.xml")));
			System.out.println("parser terminé");
			
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
