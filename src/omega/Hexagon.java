package omega;

import java.awt.*;

class Hexagon extends Polygon {
    final Color baseColor = Color.green;
    final Color selectedColor1 = Color.white;
    final Color selectedColor2 = Color.black;

    private int hasBeenSelected1;
    private int hasBeenSelected2;

    Hexagon(int x, int y) {
        for (int i = 0; i < 6; i++)
            addPoint((int) (x + 20 * Math.sin(i * Math.PI / 3)),
                    (int) (y + 20 * Math.cos(i * Math.PI / 3)));
        getBounds();
    }

    void setSelected1() {
        hasBeenSelected1 = 1;
    }

    void setSelected2() {
        hasBeenSelected2 = 1;
    }

    void draw(Graphics2D g) {

        if (hasBeenSelected1==1){
        g.setColor(selectedColor1);
        g.fillPolygon(this);
        }else if (hasBeenSelected2==1){
            g.setColor(selectedColor2);
            g.fillPolygon(this);
        }else {
            g.setColor(baseColor);
            g.fillPolygon(this);
        }

        g.setColor(Color.black);
        g.drawPolygon(this);
    }
}