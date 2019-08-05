import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class Analyzer {
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File f = new File("/home/kostenko/Projects/Java/test/test.xml");
		Document doc = builder.parse(f);
		Element root = doc.getDocumentElement();
		System.out.println(root);
		NodeList children = root.getChildNodes();
		String name = "";
		int size = 0;
		for(int i=0;i<children.getLength();i++) {
			Node child = children.item(i);
			if(child instanceof Element) {
				Element childElement = (Element) child;
				Text textNode = (Text) childElement.getFirstChild();
				String text = textNode.getData().trim();
				if(childElement.getTagName().equals("name")) name = text;
				else if(childElement.getTagName().equals("size")) size = Integer.parseInt(text);
			}
		}
		System.out.println(name);
		System.out.println(size);
	}

}
