import java.awt.*;

public class GameObject {
    private Cord cord;
    private Image objectImage;


    public Cord getCord() {
        return cord;
    }

    public Image getObjectImage() {
        return objectImage;
    }

    public void setCord(Cord cord) {
        this.cord = cord;
    }

    public void setObjectImage(Image objectImage) {
        this.objectImage = objectImage;
    }
}
