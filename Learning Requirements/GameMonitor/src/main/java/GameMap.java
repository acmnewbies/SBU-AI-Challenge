public class GameMap {
    private GameObject [][] grid;
    private int hSize ,vSize;
    GameMap(int hSize, int vSize){
        this.hSize = hSize;
        this.vSize = vSize;
        grid = new GameObject[vSize][hSize];
        initializeMap();

    }
    private void initializeMap(){
        for (int i = 0; i < vSize ; i++) {
            for (int j = 0; j < hSize; j++) {
                grid[i][j] = new GameObject(new Cord(i,j) , "empty");
            }
        }

    }

    public GameObject[][] getGrid() {
        return grid;
    }

    public int gethSize() {
        return hSize;
    }

    public int getvSize() {
        return vSize;
    }
}
//blackList