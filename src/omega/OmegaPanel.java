package omega;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class OmegaPanel extends JPanel {

    private int[][] board;

    Hexagon[][] comb;
    private int player = 1;
    private int move = 1;

    public OmegaPanel() {

        setBackground(Color.white);
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (comb[i][j] != null) {
                            if (comb[i][j].contains(e.getX(), e.getY())) {
                                if (player==1) {
                                    comb[i][j].setSelected1();
                                    repaint();
                                }else if (player==2){
                                    comb[i][j].setSelected2();
                                    repaint();
                                }
                            }
                        }
                    }
                }
                Player();
                Move();
            }
        });

        comb = new Hexagon[9][9];
        int size = 5;
        int row = 0;
        int x1 = 100, x2 = 82, x3 = 64, x4 = 46, x5 = 28, x6 = 10, x7 = -8, x8 = -26, x9 = -44, y1 = 36;
        int x = 0, y = 0;
        for (int i = 0; i < 61; i++) {
            int col = 0;
            if (i < size) {
                x = x1 + i * 36;
                y = y1;
                col = 4 + i;
                row = 0;
            } else if (i < size + 6) {
                x = x2 + (i - 5) * 36;
                y = y1 + 32;
                col = 3 + (i - 5);
                row = 1;
            } else if (i < size + 13) {
                x = x3 + (i - 11) * 36;
                y = y1 + 2 * 32;
                col = 2 + (i - 11);
                row = 2;
            } else if (i < size + 21) {
                x = x4 + (i - 18) * 36;
                y = y1 + 3 * 32;
                col = 1 + (i - 18);
                row = 3;
            } else if (i < size + 30) {
                x = x5 + (i - 26) * 36;
                y = y1 + 4 * 32;
                col = i - 26;
                row = 4;
            } else if (i < size + 38 && col < 8) {
                x = x6 + (i - 34) * 36;
                y = y1 + 5 * 32;
                col = i - 35;
                row = 5;
            } else if (i < size + 45 && col < 7) {
                x = x7 + (i - 41) * 36;
                y = y1 + 6 * 32;
                col = i - 43;
                row = 6;
            } else if (i < size + 51 && col < 6) {
                x = x8 + (i - 47) * 36;
                y = y1 + 7 * 32;
                col = i - 50;
                row = 7;
            } else if (i < size + 56 && col < 5) {
                x = x9 + (i - 52) * 36;
                y = y1 + 8 * 32;
                col = i - 56;
                row = 8;
            }
            comb[row][col] = new Hexagon(x, y);
        }

        requestFocus();
    }


    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setStroke(new BasicStroke(3));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (comb[i][j] != null) {
                    comb[i][j].draw(g);
                }
            }
        }
    }
    int Player(){
        if (player==2) {
            player--;
        } else {
            player++;
        }
        return player;
    }

    int Move(){
            move++;
        return move;
    }
}
