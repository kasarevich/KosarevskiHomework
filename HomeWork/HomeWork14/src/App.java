
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;


public class App {

    public static void main(String[] args) {

        Manager manager = new Manager(args[0]);
        try {
            manager.parseMp3();

            String duplicatesByName = "Дубликаты по имени:" + "\n" + manager.getDuplicates(manager.repeatsByName);
            System.out.println(duplicatesByName);

            String duplicatesBySum = "Дубликаты по чексумме:"+ "\n" + manager.getDuplicates(manager.repeatsByCheckSum);
            System.out.println(duplicatesBySum);


        } catch (InvalidDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        }
        }

    }


