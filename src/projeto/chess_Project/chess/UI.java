package projeto.chess_Project.chess;

public class UI {

    private static int UTF8_A = 65;

    public static void printBoard(ChessPiece[][] pieces){

        boolean lastLine = false;

        for(int i = 0; i <= pieces.length; i++){
            System.out.print(!lastLine? (8 - i) + " " : "  ");
            for(int j = 0; j <  pieces.length; j++){
                if(!lastLine){
                  printPiece(pieces[i][j]);
                }else{
                    System.out.print((char) (UTF8_A + j) + " ");
                }              
            }
            lastLine = (i + 1) == pieces.length;
            System.out.println();
        }
    }

    private static void printPiece(ChessPiece piece){

        if(piece == null){
            System.out.print("-");
        }
        else{
            System.out.print(piece);
        }

        System.out.print(" ");
    }
    
}
