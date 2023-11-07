package projeto.chess_Project;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto.chess_Project.chess.ChessPiece;
import projeto.chess_Project.chess.ChessPosition;
import projeto.chess_Project.chess.Color;

public class UI {
    
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    private static int UTF8_A = 65;

    public static void printBoard(ChessPiece[][] pieces){

        boolean lastLine = false;

        cleanScreen();

        for(int i = 0; i <= pieces.length; i++){
            System.out.print(!lastLine? (8 - i) + " " : "  ");
            for(int j = 0; j <  pieces.length; j++){
                if(!lastLine){
                  printPiece(pieces[i][j], false);
                }else{
                    System.out.print((char) (UTF8_A + j) + " ");
                }              
            }
            lastLine = (i + 1) == pieces.length;
            System.out.println();
        }
    }
    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves){
        boolean lastLine = false;

        cleanScreen();

        for(int i = 0; i <= pieces.length; i++){
            System.out.print(!lastLine? (8 - i) + " " : "  ");
            for(int j = 0; j <  pieces.length; j++){
                if(!lastLine){
                  printPiece(pieces[i][j], possibleMoves[i][j]);
                }else{
                    System.out.print((char) (UTF8_A + j) + " ");
                }              
            }
            lastLine = (i + 1) == pieces.length;
            System.out.println();
        }
  
    }

    private static void cleanScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private static void printPiece(ChessPiece piece, boolean backGround){

        if(backGround){
            System.out.print(ANSI_RED_BACKGROUND);
        }

        if(piece == null){
            System.out.print("-");
        }
        else{
            if(piece.getColor() == Color.BLACK){
                System.out.print(ANSI_YELLOW + piece);
            }
            else{
                System.out.print(ANSI_WHITE + piece);
            }
        }
        

        System.out.print(ANSI_RESET + " ");
    }

    public static ChessPosition readChessPosition(Scanner sc){
       
       try {
        String pos = sc.nextLine().toLowerCase();

        char column = pos.charAt(0);
        int row = Integer.parseInt(pos.substring(1));

        return new ChessPosition(column, row);
       }
       catch(RuntimeException err){
          throw new InputMismatchException("Formato invalido. valores validos [aA-zZ][1-9]");
       }
    }

    
}
