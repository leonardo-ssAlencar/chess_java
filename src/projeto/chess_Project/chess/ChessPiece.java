package projeto.chess_Project.chess;

import projeto.chess_Project.board.Board;
import projeto.chess_Project.board.Piece;
import projeto.chess_Project.board.Position;

public abstract class ChessPiece extends Piece{

    private Color color;


    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;        
    }

    public Color getColor() {
        return color;
    }

    public boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) this.getBoard().getPiece(position);

        return p != null && p.getColor() != this.color;
    }


}
