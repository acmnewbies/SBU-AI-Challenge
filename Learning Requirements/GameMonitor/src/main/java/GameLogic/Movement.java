package GameLogic;

import Monitor.FrameNumber;

public class Movement {
    private Cord src, dist;
    private long frames;
    public Movement(Cord src , Cord dist, FrameNumber frames){
        this.frames = frames.getValue();
        this.src = new Cord(src.getX(),src.getY());
        this.dist = new Cord(dist.getX(),dist.getY());


    }

    public long getFrames() {
        return frames;
    }

    public Cord getDist() {
        return dist;
    }

    public Cord getSrc() {
        return src;
    }
}
