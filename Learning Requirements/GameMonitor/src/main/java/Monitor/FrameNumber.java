package Monitor;

public class FrameNumber {
    private long value;

    FrameNumber(){
        this.value = 0;
    }
    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
    public void nextFrame(){
        this.value++;
    }
}
