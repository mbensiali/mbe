package xmlDomXpath;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Program {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("repertoire.xml"));
			
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xp = xpf.newXPath();
			XPathExpression xpe = xp.compile("");
			
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
