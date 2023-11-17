import javax.swing.*;
import java.awt.*;

public class Buttons extends JPanel {
    int radius;
    public Buttons(){
        //this.radius = radius;

    }

    public void buttonRadius(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Draw(g);

    }
    public void Draw(Graphics g){
        g.fillRoundRect(0,0,175,69,25,25);
    }
}
