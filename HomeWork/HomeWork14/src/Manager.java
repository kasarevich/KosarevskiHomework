import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    File dir;
    ArrayList<File> mp3Files;
    List<Artist>musicCollection = new ArrayList<>();


    public Manager(String path) {
        this.dir = new File(path);
        this.mp3Files = searchMp3(dir);
    }
    public ArrayList<File> searchMp3(File directory){
        ArrayList<File> files = new ArrayList<>();
        for(File item: directory.listFiles()){
            if(item.isDirectory()){
                searchMp3(item);
            }
            else if(item.isFile()){
                Pattern pattern = Pattern.compile("\\.mp3$");
                Matcher matcher = pattern.matcher(item.getName());
                if (matcher.find()){
                   files.add(item);
                }
            }
        }
        return files;
    }

    public void parseMp3() throws InvalidDataException, IOException, UnsupportedTagException {

        System.out.println(mp3Files.toString());

        for(File file : mp3Files){
            Mp3File mp3File = new Mp3File(file);

            String nameOfArtist;
            String nameOfAlbum;
            String title;
            Long length;

                if (mp3File.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3File.getId3v1Tag();
                    nameOfArtist = id3v1Tag.getArtist();
                    nameOfAlbum = id3v1Tag.getAlbum();
                    title = id3v1Tag.getTitle();
                }
                else {
                    nameOfArtist = "Unknown artist";
                    nameOfAlbum = "Unknown album";
                    title = "Unknown track";
                }
                length = mp3File.getLengthInSeconds();
                for(Artist artist : musicCollection){
                    Albums albums = null;
                    albums = artist.getAlbumsByArtistName(nameOfArtist);
                    if (albums == null) {
                        albums = new Albums();
                    }
                        if(albums.getSongsByAlbumName(nameOfAlbum)!=null){
                            MusicFile musicFile = new MusicFile();
                            musicFile.setNameOfTrack(title);
                            musicFile.setPath(mp3File.getFilename());
                            musicFile.setLength(length);

                            albums.getSongsByAlbumName(nameOfAlbum).add(musicFile);


                    }


                }



        }
    }

public void show(){
    System.out.println(musicCollection.toString());
}


}
