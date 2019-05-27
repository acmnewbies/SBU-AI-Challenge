package GameLogic;

public class Movement {
    private Cord src, dist;

    public Movement(Cord src , Cord dist){
        this.src = new Cord(src.getX(),src.getY());
        this.dist = new Cord(dist.getX(),dist.getY());


    }

    public Cord getDist() {
        return dist;
    }

    public Cord getSrc() {
        return src;
    }
}
