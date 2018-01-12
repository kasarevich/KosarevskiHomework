import com.mpatric.mp3agic.*;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    File dir;
    ArrayList<File> mp3Files;
    MusicCatalog musicCatalog = new MusicCatalog();

    public Manager(String path) {
        this.dir = new File(path);
        this.mp3Files = searchMp3(dir);
    }

    /**
     * Рекурсивно пробегаем по всем файлам и папкам из []args
     * Если файл mp3, добавляем его в ArrayList mp3 файлов
     * @param directory
     * @return
     */
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

    /**
     * С помощью библиотеки mp3agic получаем необходимые метаданные, и записываем в свои объекты
     * @throws InvalidDataException
     * @throws IOException
     * @throws UnsupportedTagException
     */
    public void parseMp3() throws InvalidDataException, IOException, UnsupportedTagException {

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
                    nameOfArtist = "Unknown artist"; // или библиотека так себе, или в файлах метаданные сбиты, но некоторые без данных
                    nameOfAlbum = "Unknown album";
                    title = "Unknown track";
                }
                length = mp3File.getLengthInSeconds();

                MusicFile musicFile = new MusicFile();
                musicFile.setNameOfTrack(title);
                musicFile.setLength(length);
                musicFile.setPath(mp3File.getFilename());

                createMusicCatalog(nameOfArtist,nameOfAlbum, musicFile);
                System.out.println(musicCatalog.print());// Вывод на экран и запись в файл

        }
    }
        public void createMusicCatalog(String nameOfArtist, String nameOfAlbum, MusicFile musicFile){
            if(!musicCatalog.getArtists().containsKey(nameOfArtist)){ //проверяем, есть ли такой артист
                createArtist(nameOfArtist, nameOfAlbum, musicFile);   //если нет, создаем
            }
            if(!musicCatalog.getArtists().get(nameOfArtist).containsKey(nameOfAlbum)){//если артист есть, но у него нет такого
                HashSet<MusicFile> files = new HashSet<>();                           //альбома, создаем альбом
                files.add(musicFile);
                musicCatalog.addAlbum(nameOfArtist, nameOfAlbum, files);
            }
            if(musicCatalog.getArtists().containsKey(nameOfArtist)){ // если есть артист, проверяем
                if(musicCatalog.getArtists().get(nameOfArtist).containsKey(nameOfAlbum)){ //если у него есть такой альбом
                    musicCatalog.addSong(nameOfArtist,nameOfAlbum,musicFile);             // добавляем песню
                }
                else {                                               //если у него нет альбома, создаем новый и добавляем песню
                    HashSet<MusicFile> file = new HashSet<>();
                    file.add(musicFile);
                    musicCatalog.addAlbum(nameOfArtist, nameOfAlbum, file);
                }
            }
        }

    public void createArtist(String nameOfArtist, String nameOfAlbum, MusicFile musicFile){
        HashMap<String, HashSet<MusicFile>> newAlbum = new HashMap<>();
        HashSet<MusicFile> newSongs= new HashSet<>();
        newSongs.add(musicFile);
        newAlbum.put(nameOfAlbum, newSongs);
        musicCatalog.addArtist(nameOfArtist, newAlbum);
    }


    public void fullNameDuplicates(){

    }


}
