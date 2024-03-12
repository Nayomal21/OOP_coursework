package lk.ijse.dep.service;

import lk.ijse.dep.controller.BoardController;

public class HumanPlayer extends Player {


    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
         if (board.isLegalMove(col)) { if(!board.findWinner().getWinningPiece().equals(Piece.EMPTY)) {
             board.getBoardUI().notifyWinner(board.findWinner());






         }else {

             if (!board.existLegalMoves())  new Winner(Piece.EMPTY);


         }

             board.updateMove(col,Piece.BLUE);
             board.getBoardUI().update(col,true);




         }
    }
}
