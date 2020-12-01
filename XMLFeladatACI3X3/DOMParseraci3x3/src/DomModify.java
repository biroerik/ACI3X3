import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DomModify {
    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File inputFile = new File("D:\\XMLaci3x3.xml");//hely megadása

        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(inputFile);

        Element root = doc.getDocumentElement();
        root.normalize();//olvasható egyed létrehozása

        Node beosztas = doc.getElementsByTagName("nemzetiseg").item(0);//módos tandó adattag kiválsztása
        beosztas.setTextContent("modify");//adott adatttag módos tása
        Transformer transformer = TransformerFactory
                .newInstance()
                .newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(inputFile);
        transformer.transform(source, result);//mododitások mentése

        System.out.println("kesz");
    }
}