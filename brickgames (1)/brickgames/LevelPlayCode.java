package brickgames;

import javax.swing.JPanel;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LevelPlayCode extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private int totalBricks;
    private Timer time;
    private int delay = 8;
    private int playerX = 310;
    private int level;
    private int ballposX;
    private double temp = Math.random() * (200);
    private int ballposY = (int) temp + 300;
    private int life;
    private int prompt_width;

    // these x dir and the y dir is for the speed of the ball
    // we have chages those
    private int ballXdir;
    private int ballYdir;
    private BricksClass bricks;
    private int temp_ballXdir;
    private int temp_ballYdir;
    private int temp_row;
    private int temp_column;
    private int temp_life;

    public LevelPlayCode(int ballXdir, int ballYdir, int row, int column, int life, int prompt_width,
            int level) {
        this.level = level;
        temp_life = life;
        temp_ballXdir = ballXdir;
        this.life = life;
        temp_ballYdir = ballYdir;
        temp_row = row;
        temp_column = column;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();
        this.ballXdir = ballXdir;
        this.ballYdir = ballYdir;
        totalBricks = row * column;
        bricks = new BricksClass(row, column, level);

        this.prompt_width = prompt_width;

        // this is for randomly positioning the ball
        double temp = Math.random() * (prompt_width - 200);
        ballposX = (int) temp;
    }

    public void BallReSetup() {
        double temp = Math.random() * (prompt_width - 200);
        ballposX = (int) temp;
        temp = Math.random() * (150);
        ballposY = (int) temp + 300;
        // their is an error over here

        ballXdir = temp_ballXdir;
        ballYdir = temp_ballYdir;
    }

    public void reStartTheGameWithLife() {

        BallReSetup();

        repaint();

    }

    public void reStartTheGame() {

        BallReSetup();
        playerX = 310;
        score = 0;
        totalBricks = temp_row * temp_column;
        bricks = new BricksClass(temp_row, temp_column, level);

    }

    // the terminal painting code: _
    public void paint(Graphics g) {

        // background
        g.setColor(Color.black);
        g.fillRect(1, 1, prompt_width, 600);

        // bricks drawing
        bricks.draw((Graphics2D) g);

        // score code
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Score : " + score, prompt_width - 150, 30);

        // number of life code
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Lifes : " + life, prompt_width - 250, 30);

        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 15));
        g.drawString("Press Enter to Restart!", 15, 15);

        // the moving platform
        g.setColor(Color.white);
        g.fillRect(playerX, 550, 100, 8);

        // the ball code
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);

        // game end condition: -
        if (totalBricks <= 0) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won!!", 260, 250);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Press Enter to Restart", 200, 300);

        }

        // this is when the ball is missed to collide with the platform
        // here if the ball missed and then the life is equal to zero then we reapint
        // once and then show the last message
        if (ballposY > 570) {
            if (life > 0) {
                life--;
            }
            if (life < 1) {
                play = false;
                ballXdir = 0;
                ballYdir = 0;
                if (life == 0) {
                    repaint();
                }
                // this is for the end text when the ball is missed to collide with the platform
                g.setColor(Color.red);
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("Game Over!!", (prompt_width - 150) / 2, 300);

            } else if (life >= 1) {

                play = false;
                reStartTheGameWithLife();
            }
        }

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        time.start();
        // code for movement of the ball

        BallMovement();

        // when we increment or decrenment the playerX then we have to reapint in the
        // terminal to show the chages
        // that's why we have to call the paint function again

        repaint();

    }

    private void AdditionalPoints(int i, int j) {
        if (level == 1) {
            if (i == 0 && j % 2 != 0)
                score += 1;
            else if (i == 1 && j % 2 != 0)
                score += 2;
            else if (i == 2 && j % 2 != 0)
                score += 3;
            else if (i == 3 && j % 2 != 0)
                score += 2;
            else if (i == 4 && j % 2 != 0)
                score += 1;
        }

        else if (level == 2) {
            if (i == 0 && j % 2 != 0)
                score += 1;
            else if (i == 1 && j % 2 != 0)
                score += 2;
            else if (i == 2 && j % 2 != 0)
                score += 3;
            else if (i == 3 && j % 2 != 0)
                score += 4;
            else if (i == 4 && j % 2 != 0)
                score += 3;
            else if (i == 5 && j % 2 != 0)
                score += 2;
            else if (i == 6 && j % 2 != 0)
                score += 1;
        }

        else if (level == 3) {
            if (i == 0 && j % 2 != 0)
                score += 1;
            else if (i == 1 && j % 2 != 0)
                score += 2;
            else if (i == 2 && j % 2 != 0)
                score += 3;
            else if (i == 3 && j % 2 != 0)
                score += 4;
            else if (i == 4 && j % 2 != 0)
                score += 5;
            else if (i == 5 && j % 2 != 0)
                score += 4;
            else if (i == 6 && j % 2 != 0)
                score += 3;
            else if (i == 7 && j % 2 != 0)
                score += 2;
            else if (i == 8 && j % 2 != 0)
                score += 1;
        }
    }

    private void SpeedUp() {
        if (totalBricks == 35) {
            if (level == 1) {
                ballXdir = -3;
                ballYdir = -4;
            } else if (level == 2) {
                ballXdir = -4;
                ballYdir = -5;
            } else {
                ballXdir = -5;
                ballYdir = -6;
            }
        } else if (totalBricks == 10) {
            if (level == 1) {
                ballXdir = -4;
                ballYdir = -5;
            } else if (level == 2) {
                ballXdir = -5;
                ballYdir = -6;
            } else {
                ballXdir = -6;
                ballYdir = -7;
            }
        }
    }

    // the ball movement code: -
    private void BallMovement() {

        if (play) {
            // code for detection of collison with paddle : -
            // and the score counting code: -
            if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYdir = -ballYdir;
            }
            A: for (int i = 0; i < bricks.map.length; i++) {
                for (int j = 0; j < bricks.map[0].length; j++) {
                    if (bricks.map[i][j] > 0) {
                        int brickX = j * bricks.brickWidth + 80;
                        int brickY = i * bricks.brickHeight + 50;
                        int brickWidth = bricks.brickWidth;
                        int brickHeight = bricks.brickHeight;
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;
                        if (ballRect.intersects(brickRect)) {
                            bricks.setBrickValue(0, i, j);
                            totalBricks--;
                            // here is the sound when the brick is broken

                            score += 5;

                            if (totalBricks == 35)
                                SpeedUp();
                            else if (totalBricks == 10)
                                SpeedUp();

                            // this code is used to give extra score for breaking the coloured brick
                            AdditionalPoints(i, j);

                            if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width)
                                ballXdir = -ballXdir;
                            else
                                ballYdir = -ballYdir;
                            break A;
                        }
                    }
                }
            }
            // upto here is the code for detection of collision

            // code for ball movement
            ballposX += ballXdir;
            ballposY += ballYdir;
            if (ballposX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }
            if (ballposX > prompt_width - 30) {
                ballXdir = -ballXdir;
            }

        }
    }

    // this is not needed
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    // the platform movement code: -
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            if (playerX >= prompt_width - 100) {
                playerX = prompt_width - 100;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // here we restart
            play = false;
            life = temp_life;
            reStartTheGame();
        }

    }

    // the platform movement code: -
    public void moveRight() {
        play = true;
        playerX += 20;
    }

    public void moveLeft() {
        play = true;
        playerX -= 20;
    }

    // upto here.

    // it is not need
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
