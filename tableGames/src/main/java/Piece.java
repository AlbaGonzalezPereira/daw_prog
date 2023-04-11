
/**
 * clase a que pertencerán as fichas de xogo
 * @author alba_
 */
public class Piece {
    private char id;
    private String image;
    
    //insertamos o constructor

    public Piece(char id, String image) {
        this.id = id;
        this.image = image;
    }
    
    //insertamos getter e setter
    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
