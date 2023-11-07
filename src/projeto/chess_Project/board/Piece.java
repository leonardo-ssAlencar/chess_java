package projeto.chess_Project.board;

public abstract class Piece {

    protected Position position;
    private Board board;


    public Piece(Board board){
        this.board = board;
    }


    public Position getPosition() {
        return position;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();
    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isTherePossibleMove(){
        boolean matr[][] = possibleMoves();
        for(int i = 0; i < matr.length; i++){
            for(int j =0; j < matr.length; j++){
                if(matr[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}