package projeto.chess_Project.chess;

import projeto.chess_Project.board.Board;

public class ChessMatch {
    
    private Board board;
    

    public ChessMatch(){
        
        this.board = new Board(8,8);
    }


    public ChessPiece[][] getPieces(){
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i = 0; i < board.getRows(); i++){
            for(int j = 0; j < board.getColumns(); j++){
                matrix[i][j] = (ChessPiece) board.getPiece(i, j);
            }
        }
        return matrix;
    }
}
