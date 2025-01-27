package org.pacman.data;

public enum TileType {
    WALL(false, false),
    DOT(false, true),
    ENERGIZER(false, true),
    TELEPORT(true, false),
    GHOST_HOME_ENTER(false, false),
    GHOST_HOME(false, false),
    EMPTY(true, false);

    private final boolean walkable;
    private final boolean edible;

    TileType(boolean walkable, boolean edible) {
        this.walkable = walkable;
        this.edible = edible;
    }

    public boolean isWalkable() { return walkable; }
    public boolean isEdible() { return edible; }
}