import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import  javax.swing.border;

public class DiaryPanel extends JPanel {
    Color color = new Color(255,238,198);
    public DiaryPanel(){
        //this.setSize(new Dimension(1000,600));
        this.setBounds(0,0,1000,750);
        this.setBackground(color);
        //this.setLayout(new BorderLayout(100, BorderLayout.CENTER));
        //this.setLayout(new BorderLayout());
        Menu();
    }

    public void Menu(){
        /*
        JButton button = new JButton("Make new Diary");
        JButton button1 = new JButton("View Previous");
        JButton button2 = new JButton("Settings");
        JButton button3 = new JButton("Exit");*/
        Color bcolor = new Color(117,210,104);
        JButton[] buttons = new JButton[4];
        JPanel pane = new JPanel();
        JPanel pane1 = new JPanel();
        pane.add(pane1);
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(bcolor);
            buttons[i].setBorderPainted(false);
            buttons[i].setFocusPainted(false);
            buttons[i].addMouseListener(new ButtonMouse(buttons[i]));
            buttons[i].setBorder(null);
            buttons[i].setPreferredSize(new Dimension(175,69));
            pane.add(buttons[i]);
        }
        buttons[0].setText("Make new Entry");
        buttons[1].setText("View Previous Entries");
        buttons[2].setText("Settings");
        buttons[3].setText("Quit");
        pane1.setBounds(0,0,300,500);
        pane1.setVisible(false);
        pane.setLayout(new GridLayout(0,1,0,30));
        pane.setBackground(color);

        this.add(pane);

        //if(buttons[4].)

    }
    class ButtonMouse extends MouseAdapter{
        JButton button;
        Color bcolor = new Color(117,210,104);
        public ButtonMouse(JButton button){
            this.button = button;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            button.setBackground(new Color(117,210,104,150));
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            button.setBackground(new Color(117,210,104,150));
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            button.setBackground(bcolor);
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(new Color(117,210,104,175));
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(bcolor);
            repaint();
        }
    }
}
