package projeto.chess_Project;

import projeto.chess_Project.chess.ChessMatch;
import projeto.chess_Project.chess.UI;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        ChessMatch match = new ChessMatch();

        UI.printBoard(match.getPieces());

    }

    
}