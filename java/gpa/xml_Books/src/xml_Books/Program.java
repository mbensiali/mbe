package xml_Books;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Program {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("books.xml"));
			
			NodeList resultTitle = doc.getElementsByTagName("title");
			NodeList resultBook = doc.getElementsByTagName("book");
			NodeList resultPrix = doc.getElementsByTagName("price");
						
			for (int i = 0; i < resultTitle.getLength(); i++) {
				Element balise = (Element)resultTitle.item(i);
				//System.out.println(balise.getTextContent());
			}
			
			for (int i = 0; i < resultBook.getLength(); i++) {
				Element book = (Element)resultBook.item(i);
				Element prix = (Element) resultPrix.item(i);
				double p = Double.parseDouble(prix.getTextContent());
				if ((book.getAttribute("langage").equals("en")) && (p > 10)){
					System.out.println(resultTitle.item(i).getTextContent());
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
