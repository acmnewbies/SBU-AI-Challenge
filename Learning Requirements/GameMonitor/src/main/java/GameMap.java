public class GameMap {
    private GameObject [][] grid;
    private int hSize ,vSize;
    GameMap(int hSize, int vSize){
        this.hSize = hSize;
        this.vSize = vSize;
        grid = new GameObject[vSize][hSize];
    }

}
//blackList