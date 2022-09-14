package brickgames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private Timer time;
    private int level_size = 18;
    private int delay = 8;
    JFrame object = new JFrame();

    private JFrame prev_JFrame_obj;

    public GamePlay(JFrame obj) {

        // this prev_JFrame_obj is used to despose the previos prompt or for that exit
        // feature
        prev_JFrame_obj = obj;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();
    }

    public void paint(Graphics g) {

        // the background color
        g.setColor(Color.black);
        g.fillRect(1, 1, 792, 692);

        // the information for the levels of the game
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString("Press The Corresponding Key", 210, 200);

        // display for the levels
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, level_size));
        g.drawString("LEVEL 1 - W", 280, 250);

        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, 18));
        g.drawString("LEVEL 2 - S", 280, 290);

        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, 18));
        g.drawString("LEVEL 3 - X", 280, 330);

        // exit message
        // g.setColor(Color.white);
        // g.setFont(new Font("serif", Font.BOLD, 15));
        // g.drawString("Press ESC to Exit!", 15, 15);
    }

    // code for the level 1 of the game

    void JFrameSetting() {
        prev_JFrame_obj.dispose();

        object.setResizable(false);
        object.setVisible(true);
        object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void level_1() {
        LevelPlayCode first_level = new LevelPlayCode(-2, -3, 5, 11, 1, 900, 1);
        object.setBounds(10, 10, 900, 600);
        JFrameSetting();
        object.setTitle("Paranoid Game : Level 1");
        object.add(first_level);
    }

    void level_2() {
        JFrameSetting();
        LevelPlayCode second_level = new LevelPlayCode(-3, -4, 7, 15, 2, 1100, 2);
        object.setBounds(10, 10, 1100, 600);
        object.setTitle("Paranoid Game : Level 2");
        object.add(second_level);
    }

    void level_3() {
        LevelPlayCode first_level = new LevelPlayCode(-4, -5, 9, 19, 3, 1300, 3);
        object.setBounds(10, 10, 1300, 600);
        JFrameSetting();
        object.setTitle("Paranoid Game : Level 3");
        object.add(first_level);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        // all this key storkes are working: -

        if (e.getKeyCode() == KeyEvent.VK_W) {
            level_1();

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            level_2();

        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            level_3();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        time.start();
        repaint();
    }

}
