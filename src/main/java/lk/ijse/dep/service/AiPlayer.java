package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player {
    public AiPlayer(Board newBoard) {
        super(newBoard);




    }

    @Override
    public void movePiece(int col) {

        do {

           Random rand = new Random();
            col = rand.nextInt(6);


        }while (!board.isLegalMove(col));


            board.updateMove(col, Piece.GREEN);
            board.getBoardUI().update(col, false);

            if (board.findWinner().getWinningPiece().equals(Piece.EMPTY)) {

                if (!board.existLegalMoves())
                board.getBoardUI().notifyWinner(board.findWinner());

            }




    }

    }

