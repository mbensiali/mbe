package xmlSaxWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Program {

	public static void main(String[] args) {
		try {
			XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter( new FileOutputStream("sortie.xml"), "UTF-8");
			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeStartElement("data");
			//...
			//...
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
