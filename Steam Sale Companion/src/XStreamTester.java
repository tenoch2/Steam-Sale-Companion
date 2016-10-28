import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XStreamTester {
	public static void main(String[] args){
		XStreamTester tester = new XStreamTester();
		XStream xstream = new XStream(new StaxDriver());
		
		//xstream.alias("Game", Game.class);
		xstream.processAnnotations(Game.class);
		GameOnSaleFactory gameMaker = new GameOnSaleFactory();
		Game testGame = gameMaker.makeGame("Moose Effect", 50.0, 0.1, 1);
		
		String xml = xstream.toXML(testGame);
		System.out.println(formatXml(xml));
	}
	
	public static String formatXml(String xml){
		
		try{
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			
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
