import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
    private static final String FILENAME = "mp3files.xml";

    public static void makeXML(ArrayList<File> mp3files) {
        try {

            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();

            Element file = document.createElement("file");
            document.appendChild(file);

            for (File f : mp3files) {
                Element music = document.createElement("music");
                file.appendChild(music);

                Element name = document.createElement("name");
                name.setTextContent(f.getName());
                music.appendChild(name);
                Element path = document.createElement("path");
                path.setTextContent(f.getPath());
                music.appendChild(path);
                Element size = document.createElement("size");
                size.setTextContent((String.valueOf(f.length())));
                music.appendChild(size);

                Path pat = Paths.get(f.getAbsolutePath());
                BasicFileAttributes attr = null;
                try {
                    attr = Files.readAttributes(pat, BasicFileAttributes.class);
                    FileTime ft = attr.creationTime();

                    Element date = document.createElement("date");
                    String dateCreated = ft.toString();
                    date.setTextContent(dateCreated);
                    music.appendChild(date);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
