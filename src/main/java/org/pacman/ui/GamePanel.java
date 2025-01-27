package org.pacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private final int TILES_X;
    private final int TILES_Y;
    private final int TILE_SIZE;
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;

    public GamePanel(int tilesX, int tilesY, int tileSize) {
        this.TILES_X = tilesX;
        this.TILES_Y = tilesY;
        this.TILE_SIZE = tileSize;
        this.PANEL_WIDTH = TILES_X * TILE_SIZE;
        this.PANEL_HEIGHT = TILES_Y * TILE_SIZE;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLACK);
        setupKeyListener();
    }

    private void setupKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleInput(e.getKeyCode());
            }
        });
        setFocusable(true);
    }

    private void handleInput(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_LEFT -> System.out.println("LEFT pressed");
            case KeyEvent.VK_RIGHT -> System.out.println("RIGHT pressed");
            case KeyEvent.VK_UP -> System.out.println("UP pressed");
            case KeyEvent.VK_DOWN -> System.out.println("DOWN pressed");
        }
    }

    public void update() {
        // Логика обновления состояния игры
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDebugGrid(g);
        drawPacMan(g);
    }

    private void drawDebugGrid(Graphics g) {
        g.setColor(new Color(30, 30, 30));
        for (int x = 0; x < TILES_X; x++) {
            for (int y = 0; y < TILES_Y; y++) {
                g.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private void drawPacMan(Graphics g) {
        g.setColor(Color.YELLOW);
        int centerX = PANEL_WIDTH / 2 - TILE_SIZE / 2;
        int centerY = PANEL_HEIGHT / 2 - TILE_SIZE / 2;
        g.fillOval(centerX, centerY, TILE_SIZE, TILE_SIZE);
    }
}