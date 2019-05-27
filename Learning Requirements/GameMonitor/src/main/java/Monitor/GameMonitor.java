package Monitor;

import GameLogic.Cord;
import GameLogic.GameMap;
import GameLogic.Movement;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMonitor extends JFrame implements ActionListener {
    private Map <String, Image> images = new HashMap<>();
    private GameMap gameMap;
    private int gridSize;
    private Writer jsonWriter;
    private ArrayList<Movement> moves;
    private boolean isReplay;
    private String replayJsonPath;
    private int moveCounter = 0;
    private static final int delay = 100;


    public GameMonitor(int width, int height,int gridSize, boolean isReplay){
        this.isReplay = isReplay;
        this.initializeReplay(isReplay);
        this.initializeMonitor(width, height, gridSize);
        this.loadImages();
    }

    private void initializeMonitor(int width, int height,int gridSize){
        this.initializeGameMap(width, height, gridSize);
        this.initializeTimer(delay);
        this.initializeWindowListener();
    }

    private void initializeReplay(boolean isReplay){
        //replayJsonPath = this.getClass().getResource("/JsonMoveLog.json");
        this.replayJsonPath = "/home/amirali/Desktop/AICHALLENGE/SBU-AI-Challenge/Learning Requirements/GameMonitor/src/main/resources/JsonMoveLog.json";
        if (isReplay)
            this.loadReplay();
        else
            this.initializeReplaySaver();
    }

    private void initializeGameMap(int width, int height,int gridSize){
        this.gridSize = gridSize;
        this.gameMap = new GameMap(width / gridSize , height / gridSize);
        this.initializeMonitorScreen(width, height);

    }

    private void initializeMonitorScreen(int width, int height){
        this.addKeyListener(new KeyBoardHandler(this.gameMap, this.moves, this.isReplay));
        this.setSize( width, height );
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setVisible(true);

    }

    private void initializeTimer(int delay){
        Timer timer;
        timer = new Timer(delay, this);
        timer.start();
    }

    private void loadReplay(){
        try {
            Reader reader = new FileReader(replayJsonPath);
            Gson gson = new Gson();
            TypeToken<ArrayList<Movement>> token = new TypeToken<>() {};
            this.moves = gson.fromJson(reader,token.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initializeReplaySaver(){
        this.moves = new ArrayList<>();
        try {
            this.jsonWriter = new OutputStreamWriter(new FileOutputStream(replayJsonPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeWindowListener(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               saveReplay();
               super.windowClosing(e);
            }
        });

    }

    private void saveReplay(){
        if (!isReplay) {
            Gson gson = new Gson();
            gson.toJson(moves, jsonWriter);
            try {
                jsonWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
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
            makeReplayMove();
        repaint();
    }

    private void makeReplayMove(){
        Cord blackCord = new Cord(gameMap.getBlackX(), gameMap.getBlackY());
        Cord move = moves.get(moveCounter).getDist();
        int j = moves.get(moveCounter).getDist().getX() -  moves.get(moveCounter).getSrc().getX();
        int i = moves.get(moveCounter).getDist().getY() -  moves.get(moveCounter).getSrc().getY();
        moveCounter++;
        gameMap.swap(blackCord, move);
        gameMap.moveBlack(i, j);
    }

}
