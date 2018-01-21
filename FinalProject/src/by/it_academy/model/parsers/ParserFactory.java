package by.it_academy.model.parsers;

        import by.it_academy.model.entity.Station;
        import org.xml.sax.SAXException;

        import javax.xml.parsers.ParserConfigurationException;
        import java.io.IOException;
        import java.text.ParseException;

public interface ParserFactory {
    Station parse(String nameOfFile) throws ParserConfigurationException,
            IOException, ParseException, SAXException;
}