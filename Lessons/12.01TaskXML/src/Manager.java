

import java.io.File;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager implements {
    static File dire;
    private ArrayList<File> mp3files = new ArrayList<>();

    public Manager(String [] dir) {
       // this.dire = new File(dir);

        for(String s: dir)
        {
            File f = new File(s);
            ArrayList<File> buf = searchJava(f);
            mp3files = mp3files.a);
        }


    }
    public ArrayList<File> searchJava(File directory){
        ArrayList<File> mp3 = new ArrayList<>();
        for (File item : directory.listFiles()) {
            if (item.isDirectory()) {
                searchJava(item);
            } else if (item.isFile()) {
                Pattern pattern = Pattern.compile("\\.mp3$");
                Matcher matcher = pattern.matcher(item.getName());
                if (matcher.find()) {
                    mp3.add(item);
                }
            }
        }
        return mp3;


    }

    public  void parseJava() {
        for (File m: mp3files){
            System.out.println(m.getName());
        }
        CreateXML createXML = new CreateXML();
        createXML.makeXML(mp3files);
    }

}
