import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buttons extends JPanel {
    String Label;
    int width = 175;
    int height = 50;
    boolean mousePressed = false, mouseReleased = false, mouseEntered = false;
    public Buttons(String Label){
        this.Label = Label;
        this.setBounds(0,0,width,height);
        this.setBackground(null);
        this.addMouseListener(new ButtonChanger());

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Draw(g);

    }
    public void Draw(Graphics g){
        Color colorNormal = new Color(117,210,104);
        Color colorPressed = new Color(117,210,104,125);
        Color colorEntered = new Color(117,210,104,175);

        if(mouseEntered || mouseReleased){
            g.setColor(colorEntered);
        }
        else if(mousePressed){
            g.setColor(colorPressed);
        }
        else {
            g.setColor(colorNormal);
        }
        Rectangle(g);
    }

    public void Rectangle(Graphics g){
        g.fillRoundRect(0,0,width,height,12,12);
        g.setColor(new Color(38,38,38));
        g.setFont( new Font("",Font.BOLD, 13));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(Label,(width - metrics.stringWidth(Label))/2,height/2 + g.getFont().getSize()/2);
    }

    class ButtonChanger extends MouseAdapter{

        public ButtonChanger( ){
        }
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
            mouseEntered = false;
            mouseReleased = false;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mousePressed = false;
            mouseEntered = false;
            mouseReleased = true;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mousePressed = false;
            mouseEntered = true;
            mouseReleased = false;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mousePressed = false;
            mouseEntered = false;
            mouseReleased = false;
            repaint();
        }
    }
}
