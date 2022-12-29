package com.example.ladder_snake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LadderSnake extends Application {
    public final static int tileSize=50,widthNumber=10,heightNumber=10;
    public Pane bodyPane;
    Player player1;


    Player player2;
    int diceValue;
    Label diceLabel;
    Label diceLabelBelow;
    Label universalLabel;
    Button button1;
    Button button2;
    Button dice;
     Label  player1Label,player2Label;
    Button start;
    Button Reset;
    boolean player1Turn=false, player2Turn =false,gameStarted=false;





    Pane Board(){
        AnchorPane board=new AnchorPane();
        board.setPrefHeight(tileSize*heightNumber);
        board.setPrefWidth(tileSize*widthNumber);
      for (int i=0;i<heightNumber;i++){
          for(int j=0;j<widthNumber;j++){
             Tile t=new Tile();

             t.setTranslateX(tileSize*j);
             t.setTranslateY(tileSize*i);
              board.getChildren().add(t);

          }
      }
        Image img=new Image("C:/AccioProject/MY BUILD/Ladder_Snake/src/main/java/com/example/ladder_snake/snakeLadder.jpg");
        ImageView imageView=new ImageView(img);
        imageView.setFitWidth(tileSize*widthNumber);
        imageView.setFitHeight(tileSize*heightNumber);


         player1=new Player("Prabhu", Color.GOLD,1);

         player2=new Player("Amit",Color.AQUA,1);



        board.getChildren().addAll(imageView,player1.getCircularCoin(),player2.getCircularCoin());
      board.setStyle("-fx-background-color:red");
      return board;
    }





    Pane Controls(){
        AnchorPane controls=new AnchorPane();
         button1=new Button("Player 1");
    //////////BUTTON 1,PLAYER 1 LABEL  CONTROLS/////////////////////////////////////////////////////////////////////////
        button1.setTranslateX(50);
        button1.setTranslateY(20);
        button1.setDisable(true);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    if (player1Turn) {
                        String number = diceLabel.getText();
                        if (number == null || number.isBlank()) {
                            diceLabelBelow.setText("roll me first");
                        }
                        player1.movePlayer(Integer.parseInt(number));
                        if (player1.playerWon() == false) {
                            button1.setDisable(true);
                            button2.setDisable(false);
                            player1Turn = false;
                            player2Turn = true;
                            diceLabel.setText("");
                            diceLabelBelow.setText("");
                        } else {
                            universalLabel.setText("Player 1 has won the game.Press Start to play again...");
                            player1.reset();
                            player2.reset();
                            dice.setDisable(true);
                            diceLabel.setText("");
                            diceLabelBelow.setText("");
                            start.setDisable(false);
                            player1Turn=false;
                            player2Turn =false;
                            button2.setDisable(true);
                            button1.setDisable(true);

                        }

                    } else {
                        player1Label.setText("roll the  dice first");
                    }
                }catch(Exception e){
                    System.out.println("diceLabel TextField is null.roll die to get a number");
                }
            }
        });
        player1Label=new Label("");
        player1Label.setTranslateX(50);
        player1Label.setTranslateY(4);

    ////////DICElABEL ABOVE AND BELOW   AND DICE CONTROLS//////////////////////////////////////////////////////////////
         diceLabel=new Label();
        diceLabel.setTranslateX(250);
        diceLabel.setTranslateY(15);
        dice=new Button("Roll Me");
        dice.setTranslateX(225);
        dice.setTranslateY(34);
        dice.setDisable(true);
        dice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(diceLabelBelow.getText()!=null)
                    diceLabelBelow.setText("");
                int val=setDiceValue();
                diceLabel.setText(""+val);
            }
        });
        diceLabelBelow =new Label("");
        diceLabelBelow.setTranslateX(225);
        diceLabelBelow.setTranslateY(60);

    /////////BUTTON2 AND PLAYER 2 LABEL CONTROLS////////////////////////////////////////////////////////////////////////
        button2=new Button("Player 2");
        button2.setTranslateX(400);
        button2.setTranslateY(20);
        button2.setDisable(true);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    if (player2Turn) {
                        String number = diceLabel.getText();
                        if (number == null || number.isBlank()) {
                            diceLabelBelow.setText("roll me first");
                        }
                        player2.movePlayer(Integer.parseInt(number));
                        if (player2.playerWon() == false) {
                            button2.setDisable(true);
                            button1.setDisable(false);
                            player2Turn = false;
                            player1Turn = true;
                            diceLabel.setText("");
                            diceLabelBelow.setText("");
                        } else {
                            universalLabel.setText("Player 2 has won the game.Press Start to play again...");
                            player1.reset();
                            player2.reset();
                            dice.setDisable(true);
                            dice.setDisable(true);
                            diceLabel.setText("");
                            diceLabelBelow.setText("");
                            start.setDisable(false);
                            player1Turn=false;
                            player2Turn =false;

                            button2.setDisable(true);
                            button1.setDisable(true);

                        }

                    } else {
                        player1Label.setText("roll the  dice first");
                    }
                }catch(Exception e){
                    System.out.println("diceLabel TextField is null.roll die to get a number");
                }

            }
        });
        player2Label=new Label("");
        player2Label.setTranslateX(400);
        player2Label.setTranslateY(4);


    ///////START BUTTON CONTROLS////////////////////////////////////////////////////////////////////////////////////////
        start=new Button("Start");
        start.setTranslateX(50);
        start.setTranslateY(70);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted=true;
                start.setDisable(true);
                universalLabel.setText("Game is Continuing...");
                button1.setDisable(false);
                button2.setDisable(true);
                dice.setDisable(false);
                player1Turn=true;
                player2Turn =false;
            }
        });

     //////UNIVERSAL LABEL CONTROLS/////////////////////////////////////////////////////////////////////////////////////
        universalLabel=new Label("Press Start to begin the game");
        universalLabel.setTranslateX(100);
        universalLabel.setTranslateY(78);
    //////RESET BUTTON CONTROLS/////////////////////////////////////////////////////////////////////////////////////////
        Reset=new Button("Reset");
        Reset.setTranslateX(400);
        Reset.setTranslateY(70);
        Reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                player1.reset();
                player2.reset();
                dice.setDisable(true);

                dice.setDisable(true);
                diceLabel.setText("");
                diceLabelBelow.setText("");
                start.setDisable(false);
                player1Turn=false;
                player2Turn =false;

                button2.setDisable(true);
                button1.setDisable(true);
                universalLabel.setText("Press Start to begin the game");

            }
        });
    //////ADDING CONTROLS TO ANCHOR PANE////////////////////////////////////////////////////////////////////////////////

        controls.getChildren().addAll(button1,button2,dice,start,diceLabel,universalLabel,player1Label,player2Label,diceLabelBelow,Reset);
        controls.setPrefWidth(tileSize*widthNumber);
        controls.setPrefHeight(tileSize*2);
        controls.setStyle("-fx-background-color:yellow");

        return controls;
    }

    public int setDiceValue(){
        diceValue=(int)(Math.random()*6+1);
        return diceValue;
    }






    @Override
    public void start(Stage stage) throws IOException {
        bodyPane=new Pane();
        bodyPane.setPrefWidth(tileSize*widthNumber);
        bodyPane.setPrefHeight(tileSize*heightNumber+100);
        Pane BoardPane=Board();
        Pane ControlPane=Controls();
        bodyPane.getChildren().addAll(ControlPane,BoardPane);
        ControlPane.setTranslateY(tileSize*heightNumber);


        Scene scene = new Scene(bodyPane);
        stage.setTitle("Snake & Ladder");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}