package com.dpk;

public enum Player {
    PLAYER_X('X'),
    PLAYER_O('O');

    private Character mark;

    Player(Character mark) {
        this.mark = mark;
    }

    public Character getMark() {
        return this.mark;
    }
}
