import java.util.*;

public class Albums {
    private Map<String, HashSet<MusicFile>> songs;// iмя альбома, список мп3 файлов

    public Albums() {
       songs = new HashMap<>();
    }

    public Map<String, HashSet<MusicFile>> getSongs() {
        return songs;
    }

    public void setSongs(Map<String, HashSet<MusicFile>> songs) {
        this.songs = songs;
    }

    public HashSet<MusicFile> getSongsByAlbumName(String albumName){
        if (songs.containsKey(albumName)){
            return songs.get(albumName);
        }
        else return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Albums)) return false;

        Albums albums = (Albums) o;

        return getSongs() != null ? getSongs().equals(albums.getSongs()) : albums.getSongs() == null;
    }

    @Override
    public int hashCode() {
        return getSongs() != null ? getSongs().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "songs=" + songs +
                '}';
    }
}
