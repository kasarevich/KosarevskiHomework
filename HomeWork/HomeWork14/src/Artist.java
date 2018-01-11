import java.util.HashMap;
import java.util.Map;

public class Artist {

    private Map<String, Albums> albums;//имя артиста, список альбомов

    public Artist() {
        albums = new HashMap<>();
    }

    public Map<String, Albums> getAlbums() {
        return albums;
    }

    public void setAlbums(Map<String, Albums> albums) {
        this.albums = albums;
    }
    public Albums getAlbumsByArtistName(String artistName){
        if (albums.containsKey(artistName)){
            return albums.get(artistName);
        }
        else return null;
    }










    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;

        Artist artist = (Artist) o;

        return getAlbums() != null ? getAlbums().equals(artist.getAlbums()) : artist.getAlbums() == null;
    }

    @Override
    public int hashCode() {
        return getAlbums() != null ? getAlbums().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "albums=" + albums +
                '}';
    }
}
