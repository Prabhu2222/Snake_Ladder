package com.example.ladder_snake;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class BoardCoOrdinateConnection {

    static ArrayList<Pair<Integer,Integer>> positionCoOrdinate;
    private ArrayList<Integer> snakeLadderList;

    public BoardCoOrdinateConnection(){

        populateBoardWithCoOrdinate();
        loadSnakeLadderList();
    }
    public void populateBoardWithCoOrdinate(){

        positionCoOrdinate=new ArrayList<>();
        positionCoOrdinate.add(new Pair<>(0,0));

        int tileCenterXCoOrdinate,tileCenterYCoOrdinate;
        int x,y=475,level=1;

        for(int i=0;i<LadderSnake.heightNumber;i++){
            if(level%2!=0)
                x=25;
            else x=475;
            for(int j=0;j<LadderSnake.widthNumber;j++){
                tileCenterXCoOrdinate=x;
                tileCenterYCoOrdinate=y;
                if(level%2!=0)
                  x+=50;
                else x-=50;
                positionCoOrdinate.add(new Pair<>(tileCenterXCoOrdinate,tileCenterYCoOrdinate));
            }
            y=y-50;
            level++;
        }

    }
    public void loadSnakeLadderList(){
        snakeLadderList=new ArrayList<>();
        for(int i=0;i<101;i++){
            snakeLadderList.add(i);
        }
        snakeLadderList.set(4,25);
        snakeLadderList.set(13,46);
        snakeLadderList.set(27,5);
        snakeLadderList.set(33,49);
        snakeLadderList.set(40,3);
        snakeLadderList.set(42,63);
        snakeLadderList.set(43,18);
        snakeLadderList.set(50,69);
        snakeLadderList.set(54,31);
        snakeLadderList.set(62,81);
        snakeLadderList.set(66,45);
        snakeLadderList.set(74,92);
        snakeLadderList.set(76,58);
        snakeLadderList.set(89,53);
        snakeLadderList.set(95,77);
        snakeLadderList.set(99,41);

    }
    public int getSnakeLadderPosition(int position){
        return snakeLadderList.get(position);
    }
    public static int getXCoOrdinate(int position){
         return positionCoOrdinate.get(position).getKey();
    }
    public static int getYcoOrdinate(int position){
        return positionCoOrdinate.get(position).getValue();
    }

    public static int getPosition(int x,int y){
       return positionCoOrdinate.indexOf(new Pair<>(x,y));
    }


//    public static void main(String[] args) {
//        BoardCoOrdinateConnection board=new BoardCoOrdinateConnection();
//        board.populateBoardWithCoOrdinate();
//      for(int i=0;i<positionCoOrdinate.size();i++)
//      {
//          System.out.println("position"+i+"# : "+"x-coord: " +positionCoOrdinate.get(i).getKey()+" "+"y-coord: "+positionCoOrdinate.get(i).getValue());
//      }
//    }
}
