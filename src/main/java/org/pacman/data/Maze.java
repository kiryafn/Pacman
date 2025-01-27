package org.pacman.data;

import java.awt.*;

public class Maze {
    // Константы типов тайлов
    public static final int WALL = 1;
    public static final int DOT = 2;
    public static final int ENERGIZER = 3;
    public static final int TELEPORT = 4;
    public static final int GHOST_HOME_ENTER = 5;
    public static final int GHOST_HOME = 6;
    public static final int EMPTY = 0;

    private int[][] mazeData;
    private int tileSize;
    private Color wallColor = new Color(0, 0, 255);

    public Maze(int tileSize) {
        this.mazeData = createOriginalMaze();
        this.tileSize = tileSize;
    }

    public static int[][] createOriginalMaze() {
        return new int[][]{
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
                {1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,0,1,1,3,1,1,3,1,1,0,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,0,1,6,4,6,6,4,6,1,0,1,1,0,1,1,1,1,1,1},
                {2,2,2,2,2,2,0,0,0,0,1,6,4,2,2,4,6,1,0,0,0,0,2,2,2,2,2,2},
                {1,1,1,1,1,1,0,1,1,0,1,6,6,6,6,6,6,1,0,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                {1,0,0,0,1,1,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,1,1,0,0,0,1},
                {1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
                {1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
                {1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    }

    public boolean isWalkable(int x, int y) {
        int col = x / tileSize;
        int row = y / tileSize;
        if (col < 0 || col >= 28 || row < 0 || row >= 31) return false;

        int tile = mazeData[row][col];
        return tile != WALL && tile != GHOST_HOME && tile != GHOST_HOME_ENTER;
    }

    public void draw(Graphics g) {
        for (int row = 0; row < 31; row++) {
            for (int col = 0; col < 28; col++) {
                int x = col * tileSize;
                int y = row * tileSize;

                switch (mazeData[row][col]) {
                    case WALL:
                        drawWall(g, x, y);
                        break;
                    case DOT:
                        drawDot(g, x, y);
                        break;
                    case ENERGIZER:
                        drawEnergizer(g, x, y);
                        break;
                    case TELEPORT:
                        drawTeleport(g, x, y);
                        break;
                    case GHOST_HOME_ENTER:
                        drawGhostHomeEnter(g, x, y);
                        break;
                    case GHOST_HOME:
                        drawGhostHome(g, x, y);
                        break;
                }
            }
        }
    }

    private void drawWall(Graphics g, int x, int y) {
        g.setColor(wallColor);
        g.fillRect(x, y, tileSize, tileSize);
    }

    private void drawDot(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        int dotSize = tileSize/6;
        g.fillOval(x + tileSize/2 - dotSize/2, y + tileSize/2 - dotSize/2, dotSize, dotSize);
    }

    private void drawEnergizer(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        int size = tileSize/2;
        g.fillOval(x + tileSize/2 - size/2, y + tileSize/2 - size/2, size, size);
    }

    private void drawTeleport(Graphics g, int x, int y) {
        g.setColor(Color.CYAN);
        g.drawRect(x, y, tileSize, tileSize);
    }

    private void drawGhostHomeEnter(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillRect(x, y, tileSize, tileSize/4);
    }

    private void drawGhostHome(Graphics g, int x, int y) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, tileSize, tileSize);
    }

    public int getTile(int row, int col) {
        return mazeData[row][col];
    }

    public int getRows() { return 31; }
    public int getCols() { return 28; }
}
