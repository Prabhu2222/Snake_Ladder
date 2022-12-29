package com.example.ladder_snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(){
        setWidth(LadderSnake.tileSize);
        setHeight(LadderSnake.tileSize);
        setFill(Color.GREEN);
        setStroke(Color.BLACK);
    }
}
