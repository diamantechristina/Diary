import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import  javax.swing.border;

public class DiaryPanel extends JPanel{
    Color color = new Color(255,238,198);
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);
    final int WIDTH = 1000;
    final int HEIGHT = 750;
    JPanel pane, pane1;
    JButton invisibleButton;
    Buttons[] button;

    public DiaryPanel(){
        //this.setSize(new Dimension(1000,600));
        this.setBounds(0,0,WIDTH,HEIGHT);
        this.setBackground(color);
        cardPanel.add(this);
        //this.setLayout(new BorderLayout(100, BorderLayout.CENTER));
        //this.setLayout(new BorderLayout());
        Menu();
    }

    public void Menu(){
        invisibleButton = new JButton();
        pane = new JPanel();
        pane1 = new JPanel();
        pane.add(pane1);
        invisibleButton.setPreferredSize(new Dimension(175,50));
        pane.add(invisibleButton);
        invisibleButton.setVisible(false);

        String[] labels = {"Make new Entry", "View Previous Entries","Settings","Quit"};
        button = new Buttons[4];
        for(int i = 0; i < button.length; i++){
            button[i] = new Buttons(labels[i]);
            pane.add(button[i]);
        }
        button[0].addMouseListener(new NewEntry());
        button[3].addMouseListener(new Quit());
        pane1.setBounds(0,0,500,100);
        pane1.setVisible(false);
        pane.setLayout(new GridLayout(0,1,0,HEIGHT/17));
        pane.setBackground(color);

        this.add(pane);

    }
    class SettingsGUI extends JPanel{
        public SettingsGUI(){
            this.setBounds(0,0,WIDTH,HEIGHT);
            this.setBackground(color);
        }



    }
    class NewEntry extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            new SettingsGUI();
        }
    }

    static class Quit extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(0);
        }
    }



}
