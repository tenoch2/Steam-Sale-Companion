import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XStreamTester {
	public static void main(String[] args){
		XStreamTester tester = new XStreamTester();
		XStream gameStream = new XStream(new StaxDriver());
		
		GameOnSale game = new GameOnSale("Haven", 50.00, .6, 1);
		
		String out = gameStream.toXML(game);
		System.out.println(formatXml(out));
		
	}
	
	public static String formatXml(String xml){
		
		try{
			Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
			
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
			StreamResult res = new StreamResult(new ByteArrayOutputStream());
			
			serializer.transform(xmlSource, res);
			
			return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
			
		} catch(Exception e) {
			return xml;
		}
	}
}
