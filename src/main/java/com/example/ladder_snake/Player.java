package com.example.ladder_snake;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {

    Circle circularCoin;

    String name;
    Color coinColor;
    int position;

   static BoardCoOrdinateConnection Board=new BoardCoOrdinateConnection();

   Player(){};


    public Player(String name, Color coinColor,int position){
       this.name=name;
       this.coinColor=coinColor;
       circularCoin=new Circle(LadderSnake.tileSize/2);
        circularCoin.setFill(coinColor);
        this.position=position;
        circularCoin.setTranslateX(BoardCoOrdinateConnection.getXCoOrdinate(this.position));
        circularCoin.setTranslateY(BoardCoOrdinateConnection.getYcoOrdinate(this.position));
    }


    public void movePlayer(int diceValue){
        if(position+diceValue<=100){
            position=position+diceValue;
//            circularCoin.setTranslateX(BoardCoOrdinateConnection.getXCoOrdinate(position));
//            circularCoin.setTranslateY(BoardCoOrdinateConnection.getYcoOrdinate(position));
            smoothTranslatePlayer();

            int newPosition=Board.getSnakeLadderPosition(position);
            if(newPosition!=position)
            {
                position=newPosition;

                smoothTranslatePlayer();
            }

        }
    }
    public void smoothTranslatePlayer(){
        TranslateTransition move=new TranslateTransition(Duration.millis(1500),this.circularCoin);
        move.setToX(BoardCoOrdinateConnection.getXCoOrdinate(position));
        move.setToY(BoardCoOrdinateConnection.getYcoOrdinate(position));
        move.setAutoReverse(false);
        move.play();
    }

    public void reset(){
        circularCoin.setTranslateX(BoardCoOrdinateConnection.getXCoOrdinate(1));
        circularCoin.setTranslateY(BoardCoOrdinateConnection.getYcoOrdinate(1));
        this.position=1;
    }


    public boolean playerWon(){
        if(position==100)
            return true;
        else return false;
    }



    public Circle getCircularCoin(){
        return circularCoin;
    }




    public String getPlayerName(){
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Color getCoinColor() {
        return coinColor;
    }
//        public static void main(String[] args) {
//        Player p1=new Player("ram",Color.RED,3);
//            System.out.println(p1.getCoinColor().toString());
//
//    }




}




