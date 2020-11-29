import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomRead {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File("D:\\XMLaci3x3.xml");

        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(inputFile);

        Element root = doc.getDocumentElement();
        root.normalize();

        printDocument(root, "");
    }

    public static void printDocument(Node root, String separator) {
        String nodename = root.getNodeName();
        if (!nodename.contains("text")) {
            System.out.println(separator + nodename);
        }
        separator += "  ";

        NodeList children = root.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            boolean isComplex = child.getTextContent().contains("\n");

            if (isComplex) {
                printDocument(child, separator);
            } else {
                System.out.print(separator + child.getNodeName());
                System.out.println(": " + child.getTextContent());
            }
        }
    }
}