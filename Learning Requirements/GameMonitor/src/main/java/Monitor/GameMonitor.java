package Monitor;

import GameLogic.Cord;
import GameLogic.GameMap;
import GameLogic.Movement;
import Replay.ReplayHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMonitor extends JFrame implements ActionListener {

    private Map <String, Image> images = new HashMap<>();
    private GameMap gameMap;
    private int gridSize;
    private ArrayList<Movement> moves;
    private boolean isReplay;
    private static final int delay = 100;
    private int moveCounter = 0;
    private FrameNumber frames;


    public GameMonitor(int width, int height,int gridSize, boolean isReplay){
        this.isReplay = isReplay;
        ReplayHandler.getInstance().initializeReplay(isReplay);
        this.initializeMonitor(width, height, gridSize);
        this.loadImages();
    }

    private void initializeMonitor(int width, int height,int gridSize){
        this.moves = ReplayHandler.getInstance().getMoves();
        this.initializeTimer();
        this.initializeGameMap(width, height, gridSize);
        this.initializeWindowListener();
    }



    private void initializeGameMap(int width, int height,int gridSize){
        this.gridSize = gridSize;
        this.gameMap = new GameMap(width / gridSize , height / gridSize);
        this.initializeMonitorScreen(width, height);

    }

    private void initializeMonitorScreen(int width, int height){
        this.addKeyListener(new KeyBoardHandler(this.gameMap, this.moves, this.isReplay, this.frames));
        this.setSize( width, height );
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setVisible(true);

    }

    private void initializeTimer(){
        this.frames = new FrameNumber();
        Timer timer;
        timer = new Timer(delay, this);
        timer.start();
    }



    private void initializeWindowListener(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!isReplay)
                    ReplayHandler.getInstance().saveReplay();
                super.windowClosing(e);
            }
        });

    }

    private void tryReplayMove(){
        Movement move = moves.get(moveCounter);
        if (this.isFrameSynced(move)) {
            makeReplayMove(move);
            moveCounter++;
        }
    }
    private void makeReplayMove(Movement move) {
        Cord blackCord = new Cord(gameMap.getBlackX(), gameMap.getBlackY());
        Cord dist = move.getDist();
        Cord src = move.getSrc();
        moveInGrid(src, dist);
        gameMap.swap(blackCord, dist);
    }
    private void moveInGrid(Cord src, Cord dist){
        int j = dist.getX() -  src.getX();
        int i = dist.getY() -  src.getY();
        gameMap.moveBlack(i, j);
    }

    private boolean isFrameSynced(Movement move){
        return move.getFrames() == this.frames.getValue();
    }


    private void loadImages(){
        this.loadImage("empty" ,"EmptyCell.png");
        this.loadImage("black" ,"BlackCell.png");
    }

    private void loadImage(String name, String fileName){
        URL url =this.getClass().getResource("/" + fileName);
        Image image =new ImageIcon(url).getImage().getScaledInstance(gridSize, gridSize, Image.SCALE_DEFAULT);
        images.put( name , image );

    }

    @Override
    public void paint(Graphics g) {
        for (int x = 0; x < this.getSize().width; x += gridSize)
               for (int y = 0; y < this.getSize().height; y += gridSize)
                   this.fillScreenCell(x, y, g);
        this.frames.nextFrame();
        Toolkit.getDefaultToolkit().sync();
    }

    private void fillScreenCell(int x, int y, Graphics g){
        int i = y / gridSize;
        int j = x / gridSize;
        String imgName = gameMap.getGrid()[i][j].getObjectImage();
        Image img = images.get(imgName);
        g.drawImage(img, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isReplay && moveCounter < moves.size())
            this.tryReplayMove();
        repaint();
    }



}
