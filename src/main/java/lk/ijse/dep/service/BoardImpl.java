package lk.ijse.dep.service;

import java.util.ArrayList;

public class BoardImpl implements  Board {



    private  Piece[][] pieces;

    private  BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces=new Piece[NUM_OF_COLS][NUM_OF_RAWS];
       for (Piece[] x : pieces) {
           for (int i = 0; i <x.length; i++) {
            x[i]= Piece.EMPTY;

           }
       }
        
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        System.out.println("check");



              for (int j = 0; j <pieces[col].length; j++) {
                  if (pieces[col][j].equals(Piece.EMPTY)) return j;
              }






        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {

               for (int j = 0; j <pieces[col].length; j++) {

                    if (pieces[col][j].equals(Piece.EMPTY))
                        return true;


                }





        return false;
    }

    @Override
    public boolean existLegalMoves() {


        for (int i = 0; i < pieces.length; i++) {

            for (int j = 0; j <pieces[i].length; j++) {

                    if (pieces[i][j].equals(Piece.EMPTY)){
                        System.out.println("exist");

                        return true;}
                }



        }


        return false;

    }

    @Override
    public void updateMove(int col, Piece move) {

        pieces[col][findNextAvailableSpot(col)]= move;

    }





    @Override
    public Winner findWinner() {
/*
        // check  horizontally
        for (int i = 0; i < pieces.length; i++) {  //i means col,j means raw
            for (int j = 0; j <pieces[i].length-3; j++) {

                if (    pieces[i][j]!=(Piece.EMPTY)&&
                        pieces[i][j].equals(pieces[i][j+1]) &&
                        pieces[i][j].equals(pieces[i][j+2]) &&
                        pieces[i][j].equals(pieces[i][j+3])
                ) return new Winner(pieces[i][j],i,j,i,j+3);

            }

        }


        //check vertically

        for (int i = 0; i <NUM_OF_RAWS; i++) {
            for (int j = 0; j <NUM_OF_COLS-3; j++) {

                if (    pieces[j][i]!=(Piece.EMPTY)&&
                        pieces[j][i].equals(pieces[j+1][i]) &&
                        pieces[j][i].equals(pieces[j+2][i]) &&
                        pieces[j][i].equals(pieces[j+3][i]))
                    return new Winner(pieces[i][j],i,j,i,j+3);


            }

        }

*/      if (pieces[0][0].equals(pieces[0][1]))
            return new Winner(pieces[0][0],0,0,0,3);


        return  new Winner(Piece.EMPTY);
    }





}
