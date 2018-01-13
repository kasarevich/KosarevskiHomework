import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    File dir;
    ArrayList<File> mp3Files = new ArrayList<>();
    MusicCatalog musicCatalog = new MusicCatalog();
    HashMap<String, ArrayList<String>> repeatsByCheckSum = new HashMap<>();
    HashMap<String, ArrayList<String>> repeatsByName = new HashMap<>();

    public Manager(String path) {
        this.dir = new File(path);
        searchMp3(dir);
    }

    /**
     * Рекурсивно пробегаем по всем файлам и папкам из []args
     * Если файл mp3, добавляем его в ArrayList mp3 файлов
     *
     * @param directory
     * @return
     */
    public void searchMp3(File directory) {
        for (File item : directory.listFiles()) {
            if (item.isDirectory()) {
                searchMp3(item);
            } else if (item.isFile()) {
                Pattern pattern = Pattern.compile("\\.mp3$");
                Matcher matcher = pattern.matcher(item.getName());
                if (matcher.find()) {
                    mp3Files.add(item);
                }
            }
        }
    }

    /**
     * С помощью библиотеки mp3agic получаем необходимые метаданные, и записываем в свои объекты
     *
     * @throws InvalidDataException
     * @throws IOException
     * @throws UnsupportedTagException
     */
    public void parseMp3() throws InvalidDataException, IOException, UnsupportedTagException {
        try {
            for (File file : mp3Files) {

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
                } else {
                    nameOfArtist = "Unknown artist"; // или библиотека так себе, или в файлах метаданные сбиты, но некоторые без данных
                    nameOfAlbum = "Unknown album";
                    title = "Unknown track";
                }
                MusicFile musicFile = new MusicFile();
                try {
                    musicFile.setCheckSum(getCheckSum(mp3File.getFilename()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                length = mp3File.getLengthInSeconds();
                musicFile.setNameOfTrack(title);
                musicFile.setLength(length);
                musicFile.setPath(mp3File.getFilename());

                repeat(musicFile, nameOfArtist, nameOfAlbum); // проверяем в свокей дубликаты по имени и по хэшкоду

                createMusicCatalog(nameOfArtist, nameOfAlbum, musicFile);

            }
        } catch (InvalidDataException e) {        }
        System.out.println(musicCatalog.print());// Вывод на экран и запись в файл
    }

    public void createMusicCatalog(String nameOfArtist, String nameOfAlbum, MusicFile musicFile) {
        if (!musicCatalog.getArtists().containsKey(nameOfArtist)) { //проверяем, есть ли такой артист
            createArtist(nameOfArtist, nameOfAlbum, musicFile);   //если нет, создаем
        }
        if (!musicCatalog.getArtists().get(nameOfArtist).containsKey(nameOfAlbum)) {//если артист есть, но у него нет такого
            HashSet<MusicFile> files = new HashSet<>();                           //альбома, создаем альбом
            files.add(musicFile);
            musicCatalog.addAlbum(nameOfArtist, nameOfAlbum, files);
        }
        if (musicCatalog.getArtists().containsKey(nameOfArtist)) { // если есть артист, проверяем
            if (musicCatalog.getArtists().get(nameOfArtist).containsKey(nameOfAlbum)) { //если у него есть такой альбом
                musicCatalog.addSong(nameOfArtist, nameOfAlbum, musicFile);             // добавляем песню
            } else {                                                //если у него нет альбома, создаем новый и добавляем песню
                HashSet<MusicFile> file = new HashSet<>();
                file.add(musicFile);
                musicCatalog.addAlbum(nameOfArtist, nameOfAlbum, file);
            }
        }
    }

    public void createArtist(String nameOfArtist, String nameOfAlbum, MusicFile musicFile) {
        HashMap<String, HashSet<MusicFile>> newAlbum = new HashMap<>();
        HashSet<MusicFile> newSongs = new HashSet<>();
        newSongs.add(musicFile);
        newAlbum.put(nameOfAlbum, newSongs);
        musicCatalog.addArtist(nameOfArtist, newAlbum);
    }

    public String getCheckSum(String fileName) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        FileInputStream fis = new FileInputStream(fileName);
        byte[] dataBytes = new byte[1024];
        int bytesRead;

        while ((bytesRead = fis.read(dataBytes)) > 0) {
            md.update(dataBytes, 0, bytesRead);
        }

        byte[] mdBytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mdBytes.length; i++) {
            sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }

    public void repeat(MusicFile musicFile, String nameOfArtist, String nameOfAlbum){
     /*
     * Далее проверяем по всей коллекции, берем у каждого файла хэшкод, и если он совпадает, то отправляем
     * в метод для проверки чексуммы, который создает новый список ссылок, или добавляет ссылку к существующему списку
     */
        HashMap<String, HashMap<String, HashSet<MusicFile>>> bufferCollection = musicCatalog.getArtists();
        for(String artist: bufferCollection.keySet()){
            for(String album : bufferCollection.get(artist).keySet()){
                for(MusicFile mf : bufferCollection.get(artist).get(album)){
                    if(mf.getCheckSum().equals(musicFile.getCheckSum())){  // сравниваем чексумму объекта в коллекции и отправляем на запись в свою мапу повторов
                        checkRepeatByCheckSum(musicFile, nameOfArtist, nameOfAlbum);
                    }
                    if(mf.equals(musicFile)){// сравниваем по совпадению имен. метод equals переопределен и сравнивает только по имени трека, по альбому и артисту мы получили доступ, поэтому они совпадают
                        checkRepeatByName(musicFile, nameOfArtist, nameOfAlbum);
                    }
                }
            }
        }
    }

    public void checkRepeatByCheckSum(MusicFile musicFile, String nameOfArtist, String nameOfAlbum){
        // Проверяем по чексуммам
        String keyName = nameOfArtist + " " + nameOfAlbum + " " + musicFile.getNameOfTrack();
        if (repeatsByCheckSum.containsKey(keyName)) { // если уже был файл с таким именем, добавляем файл
            if(!repeatsByCheckSum.get(keyName).contains(musicFile.getPath())) {
                repeatsByCheckSum.get(keyName).add(musicFile.getPath());
            }
        } else {                                                    // если не было, создаем лист файлов и добавляем новый файл
            ArrayList<String> files = new ArrayList<>();
            files.add(musicFile.getPath());
            repeatsByCheckSum.put(keyName, files);
        }
    }

    public void checkRepeatByName(MusicFile musicFile, String nameOfArtist, String nameOfAlbum){
        String keyName = nameOfArtist + " " + nameOfAlbum + " " + musicFile.getNameOfTrack();
        if (repeatsByName.containsKey(keyName)) {                   // если уже был файл с таким именем, добавляем файл
           if(!repeatsByName.get(keyName).contains(musicFile.getPath())) {
                repeatsByName.get(keyName).add(musicFile.getPath());
            }
        } else {                                                    // если не было, создаем лист файлов и добавляем новый файл
            ArrayList<String> files = new ArrayList<>();
            files.add(musicFile.getPath());
            repeatsByName.put(keyName, files);
        }
    }

    public String getDuplicates(HashMap<String, ArrayList<String>> repeats){
        StringBuilder sb = new StringBuilder("");
                for(String s: repeats.keySet()){
                    sb.append(s + "\n");
                    for(String path : repeats.get(s)){
                        sb.append("Путь:" + path + "\n");
                    }
                    sb.append("_______________________________________________________________\n");
                }
                return sb.toString();
    }



}