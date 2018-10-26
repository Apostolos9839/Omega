package omega;

import javax.swing.*;


public class Main  {

    public static void main(String[] args) {
            JFrame f = new JFrame("Omega Game");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.setContentPane(new OmegaPanel());
            f.setLocationRelativeTo(null);
            f.setSize(1200, 800);
    }
}

