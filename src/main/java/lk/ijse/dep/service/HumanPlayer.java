package lk.ijse.dep.service;

import lk.ijse.dep.controller.BoardController;

public class HumanPlayer extends Player {


    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
         if (board.isLegalMove(col)) {

             board.updateMove(col,Piece.BLUE);
             board.getBoardUI().update(col,true);

             if(!board.findWinner().getWinningPiece().equals(Piece.EMPTY)) {
             board.getBoardUI().notifyWinner(board.findWinner());

         }else {

             if (!board.existLegalMoves())
                 board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
         }

         }
    }
}
