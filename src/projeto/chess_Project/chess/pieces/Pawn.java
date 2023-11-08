package projeto.chess_Project.chess.pieces;

import projeto.chess_Project.board.Board;
import projeto.chess_Project.board.Position;
import projeto.chess_Project.chess.ChessPiece;
import projeto.chess_Project.chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position pos = new Position(0, 0);
        int move = 0;

        pos.setValues(this.position.getRow(), this.position.getColumn());        

        if (this.getColor() == Color.WHITE)
            do {

                
                pos.setRow(pos.getRow() - 1);

                if (getBoard().positionExists(pos)) {
                    if (getBoard().thereIsAPiece(pos) && !this.isThereOpponentPiece(pos)) {
                        continue;
                    }
                    mat[pos.getRow()][pos.getColumn()] = true;
                }
                
                
                if(move == 0){
                 Position d1 = new Position(pos.getRow(), pos.getColumn() + 1);
                 Position d2 = new Position(pos.getRow(), pos.getColumn() - 1);
                 
                 if(getBoard().positionExists(d1) && isThereOpponentPiece(d1)){
                    mat[d1.getRow()][d1.getColumn()] = true;
                 }

                 if(getBoard().positionExists(d2) && isThereOpponentPiece(d2)){
                    mat[d2.getRow()][d2.getColumn()] = true;
                 }
                
                }

                move++;
            } while (this.getMoveCount() == 0 && move < 2);

        

        else if (this.getColor() == Color.BLACK)
            do {

                pos.setRow(pos.getRow() + 1);

                if (getBoard().positionExists(pos)) {
                    if (getBoard().thereIsAPiece(pos) && !this.isThereOpponentPiece(pos)) {
                        continue;
                    }
                    mat[pos.getRow()][pos.getColumn()] = true;
                }
                
                
                if(move == 0){
                 Position d1 = new Position(pos.getRow(), pos.getColumn() + 1);
                 Position d2 = new Position(pos.getRow(), pos.getColumn() - 1);
                 
                 if(getBoard().positionExists(d1) && isThereOpponentPiece(d1)){
                    mat[d1.getRow()][d1.getColumn()] = true;
                 }

                 if(getBoard().positionExists(d2) && isThereOpponentPiece(d2)){
                    mat[d2.getRow()][d2.getColumn()] = true;
                 }
                
                }

                move++;
            } while (this.getMoveCount() == 0 && move < 2);


        

        return mat;

    }


    @Override
    public String toString() {
        return "P";
    }

}
