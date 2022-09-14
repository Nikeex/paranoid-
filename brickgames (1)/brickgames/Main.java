package brickgames;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // this is for the first prompt used to get the info for the level form the user

        JFrame obj = new JFrame();
        GamePlay gamePlay = new GamePlay(obj);
        // here we set the terminal size
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Paranoid Game");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        obj.add(gamePlay);
    }
}
