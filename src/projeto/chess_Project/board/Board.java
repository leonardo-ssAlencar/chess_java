package projeto.chess_Project.board;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){

        if(rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar tabuleiro: Necessario ao menos uma linha e uma coluna");
        }

        this.rows = rows;
        this.columns = columns;

        this.pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece getPiece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("A posição não existe");
        }
        return this.pieces[row][column];
    }
    public Piece getPiece(Position position){
        return getPiece(position.getRow(), position.getColumn());
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Já existe uma peça nessa posição");
        }
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        boolean rowCheck = (row >= 0 && row < this.rows);
        boolean columnCheck = (column >= 0 && column < this.columns);
        
        return rowCheck && columnCheck;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição inexistente");
        }
        return getPiece(position) != null;
    }
}
