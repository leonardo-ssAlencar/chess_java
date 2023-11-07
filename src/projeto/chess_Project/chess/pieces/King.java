package projeto.chess_Project.chess.pieces;

import projeto.chess_Project.board.Board;
import projeto.chess_Project.board.Position;
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

    @Override
    public boolean[][] possibleMoves() {

        
        boolean[][] mat = new boolean[getBoard().getColumns()][getBoard().getColumns()];
        Position pos = new Position(0, 0);
                
        //Acima

        pos.setValues(position.getRow() - 1,position.getColumn()-1);
        while (getBoard().positionExists(pos) && (pos.getColumn() - position.getColumn() <=  Math.abs(1))) {
            mat[pos.getRow()][pos.getColumn()] = canMove(pos);
            pos.setColumn(pos.getColumn() + 1);
        }

        pos.setValues(position.getRow() + 1,position.getColumn()-1);
        while (getBoard().positionExists(pos) && (pos.getColumn() - position.getColumn() <=  Math.abs(1))) {
            mat[pos.getRow()][pos.getColumn()] = canMove(pos);
            pos.setColumn(pos.getColumn() + 1);
        }

        pos.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(pos) && (pos.getColumn() - position.getColumn() <=  Math.abs(1))) {
            if(getBoard().getPiece(pos) != this){
                mat[pos.getRow()][pos.getColumn()] = canMove(pos);
            }
            pos.setColumn(pos.getColumn() + 1);

        }
        return mat;
    }

    private boolean canMove(Position position){
        ChessPiece piece =(ChessPiece) this.getBoard().getPiece(position);

        if(piece != null){
            return this.getColor() != piece.getColor();
        }

        return true;
        
    }

    
}
