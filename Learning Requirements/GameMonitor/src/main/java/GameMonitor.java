import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class GameMonitor extends JFrame implements ActionListener {
    private Map <String, Image> images = new HashMap<>();
    private GameMap gameMap;
    private int gridSize;
    private Timer timer;
    private final int DELAY = 140;
    GameMonitor(int width, int height,int gridSize){
        this.setSize( width, height );
        this.gridSize = gridSize;
        this.gameMap = new GameMap(height / gridSize , width / gridSize);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.loadImages();

        this.setVisible( true );
//        this.timer = new Timer();

    }

    private void loadImages(){
        String empPath = "/home/amirali/Desktop/AICHALLENGE/SBU-AI-Challenge/Learning Requirements/GameMonitor/src/main/resources/EmptyCell.png";
        Image empImage =new ImageIcon(empPath).getImage().getScaledInstance(gridSize, gridSize, Image.SCALE_DEFAULT);
        images.put("empty" , empImage);
        String blckPath = "/home/amirali/Desktop/AICHALLENGE/SBU-AI-Challenge/Learning Requirements/GameMonitor/src/main/resources/BlackCell.png";
        Image blckImage =new ImageIcon(empPath).getImage().getScaledInstance(gridSize, gridSize, Image.SCALE_DEFAULT);
        images.put( "black" , blckImage );
    }

    public void paint( Graphics g )
    {
        for ( int x = 0; x <= this.getSize().width; x += gridSize )
            for ( int y = 0; y <= this.getSize().height; y += gridSize ){
                int i = y/gridSize;
                int j = x/gridSize;

                String imgName = gameMap.getGrid()[1][1].getObjectImage();
                Image img = images.get(imgName);
                System.out.println(img.getHeight(this));
                g.drawImage(img, x, y, this);

            }
//                g.drawRect( x, y, gridSize, gridSize );

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
}
