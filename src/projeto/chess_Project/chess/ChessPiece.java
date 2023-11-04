package projeto.chess_Project.chess;

import projeto.chess_Project.board.Board;
import projeto.chess_Project.board.Piece;

public class ChessPiece extends Piece{

    private Color color;


    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;        
    }

    public Color getColor() {
        return color;
    }

}
