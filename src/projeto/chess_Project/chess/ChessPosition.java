package projeto.chess_Project.chess;

import projeto.chess_Project.board.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column ,int row ) {
        if((column < 'a' || column > 'h') || (row < 0 || row > 8) ){
            throw new ChessException("Erro instanciando chessPostion");
        }

        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        int row = (8 - this.row);
        int column = (int) (this.column - 'a');

        return new Position(row, column);

    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)(position.getColumn() + 'a') , 8 - position.getRow());
    }

    @Override
    public String toString() {
        return ""+this.column+this.row;
    }
    
}
