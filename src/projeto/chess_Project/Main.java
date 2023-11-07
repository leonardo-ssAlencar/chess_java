package projeto.chess_Project;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto.chess_Project.chess.ChessException;
import projeto.chess_Project.chess.ChessMatch;
import projeto.chess_Project.chess.ChessPosition;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        ChessMatch match = new ChessMatch();
        Scanner sc = new Scanner(System.in);


        while(true){
            try{
                UI.printBoard(match.getPieces());
             
                System.out.print("\nOrigin: ");
                ChessPosition origin = UI.readChessPosition(sc);

                boolean[][] possibleMove = match.possibleMoves(origin);

                UI.printBoard(match.getPieces(), possibleMove);
                

                System.out.print("\nDestination: ");
                ChessPosition destination = UI.readChessPosition(sc);

                match.peformChessMove(origin, destination);

        }
        catch(ChessException err){
            System.out.println(err.getMessage());
            sc.nextLine();
        }
        catch(InputMismatchException err){
            System.out.println(err.getMessage());
            sc.nextLine();
        }

        }


    }

    
}