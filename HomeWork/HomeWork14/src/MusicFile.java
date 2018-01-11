public class MusicFile {
    private String nameOfTrack;
    private long length;
    private String path;

    public String getNameOfTrack() {
        return nameOfTrack;
    }

    public void setNameOfTrack(String nameOfTrack) {
        this.nameOfTrack = nameOfTrack;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicFile)) return false;

        MusicFile musicFile = (MusicFile) o;

        if (getLength() != musicFile.getLength()) return false;
        if (getNameOfTrack() != null ? !getNameOfTrack().equals(musicFile.getNameOfTrack()) : musicFile.getNameOfTrack() != null)
            return false;
        return getPath() != null ? getPath().equals(musicFile.getPath()) : musicFile.getPath() == null;
    }

    @Override
    public int hashCode() {
        int result = getNameOfTrack() != null ? getNameOfTrack().hashCode() : 0;
        result = 31 * result + (int) (getLength() ^ (getLength() >>> 32));
        result = 31 * result + (getPath() != null ? getPath().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MusicFile{" +
                "nameOfTrack='" + nameOfTrack + '\'' +
                ", length=" + length +
                ", path='" + path + '\'' +
                '}';
    }
}
