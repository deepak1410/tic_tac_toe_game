package com.dpk;

public enum GameStatus {
    NOT_STARTED("not_started"),
    ON("on"),
    COMPLETED_BY_WIN("completed_by_win"),
    COMPLETED_BY_DRAW("completed_by_draw");

    GameStatus(String status) { }
}
