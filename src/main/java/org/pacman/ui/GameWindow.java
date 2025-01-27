package org.pacman.ui;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    private GamePanel gamePanel;
    private Timer gameTimer;
    private final int TILE_SIZE = 24;
    private final int TILES_X = 28;
    private final int TILES_Y = 31;

    public GameWindow() {
        initializeWindow();
        setupGamePanel();
        setupGameTimer();
    }

    private void initializeWindow() {
        this.setTitle("Pac-Man");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        int windowWidth = TILES_X * TILE_SIZE + this.getInsets().left + this.getInsets().right;
        int windowHeight = TILES_Y * TILE_SIZE + this.getInsets().top + this.getInsets().bottom + 30;

        this.setSize(windowWidth, windowHeight);
        this.setLocationRelativeTo(null);
    }

    private void setupGamePanel() {
        gamePanel = new GamePanel(TILES_X, TILES_Y, TILE_SIZE);
        this.add(gamePanel, BorderLayout.CENTER);
    }

    private void setupGameTimer() {
        gameTimer = new javax.swing.Timer(16, e -> {
            gamePanel.update();
            gamePanel.repaint();
        });
    }

    public void startGame() {
        this.setVisible(true);
        gameTimer.start();
        gamePanel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameWindow game = new GameWindow();
            game.startGame();
        });
    }
}