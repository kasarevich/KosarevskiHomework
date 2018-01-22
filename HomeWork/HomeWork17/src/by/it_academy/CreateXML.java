package by.it_academy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateXML {
    public void create(HashMap<String,ArrayList<String>> catalog) {
        try{
        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().newDocument();

        Element file = document.createElement("files");
        document.appendChild(file);

            int counter = 0;

        for (String extName: catalog.keySet()) {

            Element ext = document.createElement("ext_" + counter);
            ext.setAttribute("ext", extName);

            StringBuilder sb = new StringBuilder();

            for(String fileName: catalog.get(extName)){
                sb.append(fileName+ ",\n\t\t");
            }

            ext.setTextContent(sb.toString());
            file.appendChild(ext);
            counter++;

        }
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(
                    new File(System.getProperty("user.dir")
                            + File.separator + "result.xml"));
            transformer.transform(source, result);

            System.out.println("Документ сохранен!");

    } catch (ParserConfigurationException
                | TransformerConfigurationException ex) {
        ex.printStackTrace();
    } catch (TransformerException e) {
        e.printStackTrace();
    }
    }
}
