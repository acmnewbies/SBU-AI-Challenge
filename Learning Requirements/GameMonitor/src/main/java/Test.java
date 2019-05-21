import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test implements ActionListener {

    public static void main(String[] args)  {
        GameMonitor gm = new GameMonitor(1000 , 500 , 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
