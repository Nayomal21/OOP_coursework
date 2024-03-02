package lk.ijse.dep.service;

public class BoardImpl implements  Board {



    private  Piece[][] pieces;

    private  BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces=new Piece[NUM_OF_COLS][NUM_OF_RAWS];
       for (Piece[] x : pieces) {
           for (int i = 0; i <5; i++) {
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

        for (int i = 0; i < pieces.length; i++) {
          if (pieces[i].equals(col))  {
              for (int j = 0; j <pieces[i].length; j++) {
                  if (pieces[i][j].equals(Piece.EMPTY)) return j;
              }


          }
        }


        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i].equals(col))  {
                for (int j = 0; j <pieces[i].length; j++) {
                    if (pieces[i][j].equals(Piece.EMPTY)) return true;
                }


            }
        }


        return false;
    }

    @Override
    public boolean existLegalMoves() {


        for (int i = 0; i < pieces.length; i++) {

            for (int j = 0; j <pieces[i].length; j++) {
                    if (pieces[i][j].equals(Piece.EMPTY)) return true;
                }



        }


        return false;

    }

    @Override
    public void updateMove(int col, Piece move) {



    }





    @Override
    public Winner findWinner() {

        return  null;

    }





}
