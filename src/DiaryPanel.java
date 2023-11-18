import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import  javax.swing.border;

public class DiaryPanel extends JPanel{
    Color color = new Color(255,238,198);
    final int WINDOW_WIDTH = 1000;
    final int WINDOW_HEIGHT = 750;
    JPanel pane, pane1;
    JButton invisibleButton;
    Buttons[] button;
    JPanel panelSettings;


    public DiaryPanel(){
        //this.setSize(new Dimension(1000,600));
        this.setBounds(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setBackground(color);
        this.add(new NewEntryGUI());
        //this.setLayout(new BorderLayout(100, BorderLayout.CENTER));
        //this.setLayout(new BorderLayout());
        Menu();
    }

    public void Menu(){
        invisibleButton = new JButton();
        pane = new JPanel();
        pane1 = new JPanel();
        //pane.add(pane1);
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
        //pane1.setBounds(0,0,500,100);
        //pane1.setVisible(false);
        pane.setLayout(new GridLayout(0,1,0, WINDOW_HEIGHT /13));
        pane.setBackground(color);

        this.add(pane);

    }
    class NewEntryGUI extends JPanel{
        public NewEntryGUI(){
            this.setBounds(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
            this.setBackground(null);
            bookBG();
        }

        public void bookBG(){
            panelSettings = new JPanel();
            JButton invisibleButton = new JButton();
            invisibleButton.setPreferredSize(new Dimension(175,50));
            invisibleButton.setVisible(false);
            panelSettings.setBackground(null);
            panelSettings.setLayout(new GridLayout(1,1,(WINDOW_WIDTH *2)/3, WINDOW_HEIGHT /17));

            Buttons menuButton = new Buttons("Back to Menu");
            menuButton.addMouseListener(new MenuButton());
            panelSettings.add(menuButton);
            panelSettings.add(invisibleButton);
            panelSettings.setVisible(false);
            this.add(panelSettings);
        }
    }
    class MenuButton extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            pane.setVisible(true);
            panelSettings.setVisible(false);
            repaint();
        }
    }
    class NewEntry extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
           pane.setVisible(false);
           panelSettings.setVisible(true);
           repaint();
        }
    }

    static class Quit extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(0);
        }
    }



}
