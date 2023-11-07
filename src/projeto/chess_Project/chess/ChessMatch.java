package projeto.chess_Project.chess;

import projeto.chess_Project.board.Board;
import projeto.chess_Project.board.Piece;
import projeto.chess_Project.board.Position;
import projeto.chess_Project.chess.pieces.King;
import projeto.chess_Project.chess.pieces.Rook;

public class ChessMatch {
    
    private Board board;
    

    public ChessMatch(){
        
        this.board = new Board(8,8);
        InitialSetup();
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
    public ChessPiece peformChessMove(ChessPosition origin, ChessPosition destination){
        Position oPosition = origin.toPosition();
        Position dPosition = destination.toPosition();

        validateOriginPosition(oPosition);
        validatedestinationPosition(oPosition, dPosition);

        Piece capturedPiece = makeMove(oPosition, dPosition);
        return (ChessPiece) capturedPiece;
    }


    private Piece makeMove(Position origin, Position destination) {
        Piece p = board.removePiece(origin);
        Piece captured = board.removePiece(destination);
        
        board.placePiece(p, destination);
        
        return captured;
    }


    private void validateOriginPosition(Position origin) {

        if(!board.thereIsAPiece(origin)){
            throw new ChessException("Não existe peça na posição");
        }
        if(!board.getPiece(origin).isTherePossibleMove()){
            throw new ChessException("Não existe movimentos possiveis para essa peça");
        }

    }

    private void validatedestinationPosition(Position origin, Position destination){

        System.out.println("Ola");
        if(!board.getPiece(origin).possibleMove(destination)){
            throw new ChessException("Não é um movimento possivel");
        }

    }


    private void placeNewPiece(char column, int row, ChessPiece piece ){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    

    private void InitialSetup(){
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

    }
}
