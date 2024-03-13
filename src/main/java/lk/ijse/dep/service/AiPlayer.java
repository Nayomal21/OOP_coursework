package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player {
    public AiPlayer(Board newBoard) {
        super(newBoard);




    }

    @Override
    public void movePiece(int col) {

        do {

         //  Random rand = new Random();
          //  col = rand.nextInt(6);
            int range = 6;
            col = (int)(Math.random()*range);

        }while (!board.isLegalMove(col));


            board.updateMove(col, Piece.GREEN);
            board.getBoardUI().update(col, false);

        if(board.findWinner().getWinningPiece()!=(Piece.EMPTY)) {
            board.getBoardUI().notifyWinner(board.findWinner());






        }else {

            if (!board.existLegalMoves())  board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));


        }




    }

    }

