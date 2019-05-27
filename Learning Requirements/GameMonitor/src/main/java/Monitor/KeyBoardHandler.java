package Monitor;

import GameLogic.Cord;
import GameLogic.GameMap;
import GameLogic.Movement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyBoardHandler extends KeyAdapter {

    private ArrayList<Movement> moves;
    private GameMap gameMap;
    private boolean isReplay;
    private int keyCode;

    KeyBoardHandler(GameMap gameMap, ArrayList<Movement> moves, boolean isReplay ){
        this.moves = moves;
        this.gameMap = gameMap;
        this.isReplay = isReplay;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isReplay)
            return;
        this.keyCode= e.getKeyCode();
        detectArrowKeys();
    }

    private boolean isKey(int keyCode){
        return this.keyCode == keyCode;
    }

    private void makeMove(int vertical, int horizantal){
        Cord blackCord = new Cord(gameMap.getBlackX() , gameMap.getBlackY() );
        Cord move = new Cord(gameMap.getBlackX() + horizantal, gameMap.getBlackY() + vertical );
        moves.add(new Movement(blackCord , move));
        gameMap.swap(blackCord , move );
        gameMap.moveBlack(vertical ,horizantal);
    }

    private void detectArrowKeys(){
        if (isKey(KeyEvent.VK_LEFT))
            makeMove(0, -1);
        else if (isKey(KeyEvent.VK_RIGHT))
            makeMove(0, 1);
        else if (isKey(KeyEvent.VK_UP))
            makeMove(-1, 0);
        else if (isKey(KeyEvent.VK_DOWN))
            makeMove(1, 0);
    }

}