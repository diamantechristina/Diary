import javax.swing.*;
import java.awt.*;

public class DiaryFrame extends JFrame {

    public DiaryFrame(){
        this.add(new DiaryPanel());
        this.setSize(new Dimension(1000,700));
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
