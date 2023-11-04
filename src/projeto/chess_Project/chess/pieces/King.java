package projeto.chess_Project.chess.pieces;

import projeto.chess_Project.board.Board;
import projeto.chess_Project.chess.ChessPiece;
import projeto.chess_Project.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    
}
