package brickgames;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class BricksClass {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public BricksClass(int row, int col, int level) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {

            // map[0].length
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
        if (level == 1) {
            brickWidth = 740 / col;
            brickHeight = 150 / row;
        } else if (level == 2) {
            brickWidth = 940 / col;
            brickHeight = 150 / row;
        } else {
            brickWidth = 1140 / col;
            brickHeight = 150 / row;
        }
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {

            // map[0].length
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    if (j % 2 == 0) {
                        g.setColor((Color.white));
                    } else {
                        if (i == 0)
                            g.setColor((Color.red));
                        else if (i == 1)
                            g.setColor((Color.blue));
                        else if (i == 2)
                            g.setColor((Color.green));
                        else if (i == 3)
                            g.setColor((Color.pink));
                        else if (i == 4)
                            g.setColor((Color.orange));
                        else if (i == 5)
                            g.setColor(Color.MAGENTA);
                        else if (i == 6)
                            g.setColor(Color.gray);
                        else if (i == 7)
                            g.setColor(Color.CYAN);
                        else if (i == 8)
                            g.setColor(Color.LIGHT_GRAY);
                    }
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    // adding the space between the bricks
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }
}
