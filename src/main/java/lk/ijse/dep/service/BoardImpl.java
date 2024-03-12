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
      //  pieces=new Piece[NUM_OF_COLS][NUM_OF_RAWS];
        //check vertically
        for (int i = 0; i <pieces.length ; i++) {

             for (int j = 0; j <pieces[i].length-3; j++) {
                if (pieces[i][j]!=Piece.EMPTY && pieces[i][j]==pieces[i][j+1] && pieces[i][j]==pieces[i][j+2] && pieces[i][j]==pieces[i][j+3]) {


                    return new Winner(pieces[i][j], i, j, i, j + 3);
                }
            }


        }

        for (int i = 0; i <pieces.length-3 ; i++) {
            for (int j = 0; j <pieces[i].length; j++) {
                if (pieces[i][j]!=Piece.EMPTY && pieces[i][j]==pieces[i+1][j] && pieces[i][j]==pieces[i+2][j] && pieces[i][j]==pieces[i+3][j]) {
                    return new Winner(pieces[i][j],i,j,i+3,j);

                }


                }


            }


        return  new Winner(Piece.EMPTY);
    }





}
