package GameLogic;

public class Cord {
    private int x,y;
    public Cord(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }




    public void moveCord(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

}
