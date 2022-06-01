import javax.persistence.Entity;

@Entity
public class CD extends Product {
    private String artist;

    public CD() {
    }

    public CD(String artist, String name, String description) {
        super(name,description);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
