package by.it_academy;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class App {

    public static HashMap<String, ArrayList<String>> filesMap = new HashMap();

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            File dir = new File(args[i]);
            serachFile(dir);
        }
            CreateXML creator = new CreateXML();
            creator.create(filesMap);

    }


    public static void serachFile(File dir){
        for (File file: dir.listFiles()){
        if(file.isDirectory()){
            serachFile(file);
        }else {
            addFile(file);
        }
        }
    }



    public static void addFile(File f){
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }

        if(filesMap.get(ext) == null){
            ArrayList<String> files = new ArrayList<>();
            files.add(f.getName());
            filesMap.put(ext, files);
        }else{
            filesMap.get(ext).add(f.getName());
        }
    }



}
