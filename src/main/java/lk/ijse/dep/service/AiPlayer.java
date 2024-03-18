package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player {

    public AiPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int col) {


         int x = colChosser(); // check is there the best column to win
         if (x== -1){ // if x =-1 means there is no best column to win or defend

            //so assign a random value by using Math.random
             do {


                 int range = 6;
                 col = (int)(Math.random()*range);

             }while (!board.isLegalMove(col));
         }else {

             col = x;
         }




        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);

        if(board.findWinner().getWinningPiece()!=(Piece.EMPTY)) {
            board.getBoardUI().notifyWinner(board.findWinner());

        }else {

            if (!board.existLegalMoves())  board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }

    }
        // Expert level AI
    private int colChosser() {

        //check if AI put ball into every column , can AI win

        for (int i = 0; i <6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.GREEN);
                if (board.findWinner().getWinningPiece() == Piece.GREEN) { //if AI can win by those attempt

                    board.updateMove(i, row, Piece.EMPTY); //clear array
                    return i; // return i as best column to win
                }
                else{
                    board.updateMove(i, row, Piece.EMPTY);
                    //if AI cant win by using that move , clear the board


                }



            }

        }


        //check if Human put ball into every column , can Human win

        for (int i = 0; i <6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.BLUE);
                if (board.findWinner().getWinningPiece() == Piece.BLUE) {//if AI can win by those attempt

                    board.updateMove(i, row, Piece.EMPTY);//clear array
                    return i;// return i as best column to defend because if not we put ball to this time , human going to win
                }
                else{
                    board.updateMove(i, row, Piece.EMPTY);//clear array


                }
            }

        }
      return -1; //return -1 as a symbol of no special chances by this move
    }


/*
    // Intermediate level ai

    private   Piece[][]    pieces = board.getPieces(); // use for Intermediate level AI

      @Override
    public void movePiece(int col) {



        int x = defend();
        int y =win();

        if (x == -1 && y ==-1) {
            do {

                //  Random rand = new Random();
                //  col = rand.nextInt(6);
                int range = 6;
                col = (int) (Math.random() * range);

            } while (!board.isLegalMove(col));


        } else if(x!= -1 && y ==-1) {

            col = x;
        }  if (x== -1 && y !=-1) {
            col= y;
        }  if (x!=-1 && y!=-1) {
            col=y;
        }
        System.out.println(col);


        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);
        Winner winner = board.findWinner();
        if (winner.getWinningPiece() != Piece.EMPTY) {
            board.getBoardUI().notifyWinner(winner);

        } else if (!board.existLegalMoves()) {
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

    private int defend() {


        for (int i = 0; i < pieces.length; i++) {

            for (int j = 0; j < pieces[i].length - 3; j++) {
                if (pieces[i][j] != Piece.EMPTY  && Piece.BLUE ==pieces[i][j]&&pieces[i][j]== pieces[i][j + 1]
                        && Piece.BLUE == pieces[i][j + 2] && j+2!=4 && board.isLegalMove(i)
                ) {
                    return i;


                }
            }


        }

        for (int i = 0; i < pieces.length - 3; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] != Piece.EMPTY && Piece.BLUE ==pieces[i][j]&&pieces[i][j] == pieces[i + 1][j] && Piece.BLUE == pieces[i + 2][j] && i+2!=5  && board.isLegalMove(i+3)) {
                    return i + 3;
                }


            }


        }
        return -1;
    }
    private int win() {


        for (int i = 0; i < pieces.length; i++) {

            for (int j = 0; j < pieces[i].length - 2; j++) {
                if (pieces[i][j] != Piece.EMPTY  && Piece.GREEN ==pieces[i][j]&&pieces[i][j]== pieces[i][j + 1]
                        && Piece.GREEN == pieces[i][j + 2] && j+2!=4 && board.isLegalMove(i)
                ) {
                    return i;


                }
            }


        }

        for (int i = 0; i < pieces.length - 2; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] != Piece.EMPTY && Piece.GREEN ==pieces[i][j]&&pieces[i][j] == pieces[i + 1][j] && Piece.GREEN == pieces[i + 2][j] && i+2!=5  ) {
                  if  (board.isLegalMove(i+3))
                    return i + 3;

                  if  (board.isLegalMove(i-1))

                    return i -1;
                }


            }


        }
        return -1;
    }


  //  * */

}