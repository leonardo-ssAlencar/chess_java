package projeto.chess_Project.chess.pieces;

import projeto.chess_Project.board.Board;
import projeto.chess_Project.board.Position;
import projeto.chess_Project.chess.ChessPiece;
import projeto.chess_Project.chess.Color;

public class Rook extends ChessPiece{

    public Rook(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString() {
        
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean mat[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];
        ChessPiece piece = (ChessPiece)this;


        Position pos = new Position(this.position.getRow() + 1, this.position.getColumn());
        while (getBoard().positionExists(pos)){
            if(getBoard().thereIsAPiece(pos)) {
                if(piece.isThereOpponentPiece(pos)){
                    mat[pos.getRow()][pos.getColumn()] = true;
                }
                break;
            }
            mat[pos.getRow()][pos.getColumn()] = true;
            pos.setRow(pos.getRow() + 1);
        }

        pos.setValues(this.position.getRow() - 1, this.position.getColumn());
        while (getBoard().positionExists(pos)){
            if(getBoard().thereIsAPiece(pos)) {
                if(piece.isThereOpponentPiece(pos)){
                    mat[pos.getRow()][pos.getColumn()] = true;
                }
                break;
            }
            mat[pos.getRow()][pos.getColumn()] = true;
            pos.setRow(pos.getRow() - 1);
        }

        pos.setValues(this.position.getRow(), this.position.getColumn() + 1);
        while (getBoard().positionExists(pos)){
            if(getBoard().thereIsAPiece(pos)) {
                if(piece.isThereOpponentPiece(pos)){
                    mat[pos.getRow()][pos.getColumn()] = true;
                }
                break;
            }
            mat[pos.getRow()][pos.getColumn()] = true;
            pos.setColumn(pos.getColumn() + 1);
        }

        pos.setValues(this.position.getRow(), this.position.getColumn() - 1);
        while (getBoard().positionExists(pos)){
            if(getBoard().thereIsAPiece(pos)) {
                if(piece.isThereOpponentPiece(pos)){
                    mat[pos.getRow()][pos.getColumn()] = true;
                }
                break;
            }
            mat[pos.getRow()][pos.getColumn()] = true;
            pos.setColumn(pos.getColumn() - 1);
        }



        return mat;
    }


    
}
