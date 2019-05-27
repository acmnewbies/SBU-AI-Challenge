package GameLogic;

public class GameMap {
    private GameObject[][] grid;
    private int hSize, vSize;
    private int blackX, blackY;
    public GameMap(int hSize, int vSize){
        this.hSize = hSize;
        this.vSize = vSize;
        grid = new GameObject[vSize][hSize];
        initializeMap();

    }
    private void initializeMap(){
        this.blackX = this.hSize /2;
        this.blackY = this.vSize /2;
        for (int i = 0; i < vSize ; i++)
            for (int j = 0; j < hSize; j++)
                grid[i][j] = new GameObject(new Cord(j,i) , "empty");
        this.grid[blackY][blackX] = new GameObject(new Cord(blackX, blackY) , "black");
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

    public void swap(Cord c1, Cord c2){
        GameObject t1 = this.grid[c1.getY()][c1.getX()];
        GameObject t2 = this.grid[c2.getY()][c2.getX()];
        GameObject t3 = new GameObject(new Cord(t1.getCord().getX() , t2.getCord().getY()) , t1.getObjectImage());
        t1.setCord(t2.getCord());t1.setObjectImage(t2.getObjectImage());
        t2.setCord(t3.getCord());t2.setObjectImage(t3.getObjectImage());
    }

    public int getBlackX() {
        return blackX;
    }

    public int getBlackY() {
        return blackY;
    }
    public void moveBlack(int i, int j){
        this.blackY += i;
        this.blackX += j;

    }
}
//blackList