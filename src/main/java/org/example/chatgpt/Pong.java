package org.example.chatgpt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serial;
import javax.swing.JFrame;

public class Pong extends JFrame implements KeyListener {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private boolean upPressed = false;
    private boolean downPressed = false;

    private int ballX = WIDTH / 2;
    private int ballY = HEIGHT / 2;
    private int ballSpeedX = -5;
    private int ballSpeedY = 5;

    private int paddleX = 10;
    private int paddleY = HEIGHT / 2 - 50;
    private int paddleSpeedY = 0;

    public Pong() {
        super("org.example.chatgpt.Pong");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);
        runGameLoop();
    }

    public void runGameLoop() {
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // move the ball
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // bounce the ball off the top and bottom edges
        if (ballY < 0 || ballY > HEIGHT - 10) {
            ballSpeedY *= -1; // reverse the direction
        }

        // bounce the ball off the right edge
        if (ballX > WIDTH - 10) {
            ballSpeedX *= -1; // reverse the direction
        }

        // reset the game if the ball goes off the left edge
        if (ballX < 0) {
            resetGame();
        }

        // move the paddle according to user input
        paddleY += paddleSpeedY;

        // keep the paddle inside the window
        if (paddleY < 0) {
            paddleY = 0;
        }

        if (paddleY > HEIGHT - 100) {
            paddleY = HEIGHT - 100;
        }

        // check for collision between the ball and the paddle
        if (ballX == paddleX + 10 && ballY >= paddleY && ballY <= paddleY + 100) {
            ballSpeedX *= -1; // reverse the direction
        }
    }

    public void resetGame() {
        // reset the ball position and speed
        ballX = WIDTH / 2;
        ballY = HEIGHT / 2;
        ballSpeedX = -5;
        ballSpeedY = 5;

        // reset the paddle position and speed
        paddleX = 10;
        paddleY = HEIGHT / 2 - 50;
        paddleSpeedY = 0;
    }

    public void paint(Graphics g) {
        super.paint(g);

        // draw a black background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // draw a white ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 10, 10);

        // draw a white paddle
        g.setColor(Color.WHITE);
        g.fillRect(paddleX, paddleY, 10, 100);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
            paddleSpeedY = -5;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
            paddleSpeedY = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
            paddleSpeedY = 0;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
            paddleSpeedY = 0;
        }
    }

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new Pong();
    }
}