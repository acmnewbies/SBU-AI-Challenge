package GameLogic;

import java.awt.*;

public class GameObject {
    private Cord cord;
    private String objectImage;

    GameObject(Cord cord, String objectImage){
        this.cord = cord;
        this.objectImage = objectImage;
    }

    public Cord getCord() {
        return cord;
    }

    public String getObjectImage() {
        return objectImage;
    }

    public void setCord(Cord cord) {
        this.cord = new Cord(cord.getX() , cord.getY());
    }

    public void setObjectImage(String objectImage) {
        this.objectImage = objectImage;
    }
}
