import java.util.ArrayList;

public class Board {
    private static int[] rows;
    private static int[] columns;
    private static ChessPiece[][] pieces;
    private static char[][] colors;
    private static int[] kings = {-1,-1,-1,-1};

    public Board(int numRows, int numColumns){
        rows = new int[numRows];
        columns = new int[numColumns];
        pieces = new ChessPiece[numRows][numColumns];
        colors = new char[numRows][numColumns];
    }

    public static ChessPiece getPiece(int row, int col){
        return(pieces[row][col]);
    }

    public static char getColor(int row, int col){
        return(colors[row][col]);
    }

    public static void move(int initRow, int initCol, int finalRow, int finalCol){
        ChessPiece temp = pieces[initRow][initCol];
        pieces[initRow][initCol] = null;
        pieces[finalRow][finalCol] = temp;
        colors[finalRow][finalCol] = colors[initRow][initCol];
        colors[initRow][initCol] = 'n';
    }

    public static void moveKing(char color, int row, int col){
        if(color == 'w'){
            kings[0] = row;
            kings[1] = col;
        }else if(color == 'b'){
            kings[2] = row;
            kings [3] = col;
        }
    }

    public static void addPiece(ChessPiece piece, char color){
        pieces[piece.getRow()][piece.getColumn()] = piece;
        colors[piece.getRow()][piece.getColumn()] = color;
    }

    public static ArrayList<ChessPiece> getPieces(){
        ArrayList<ChessPiece> onBoard = new ArrayList<>();
        for(int row:rows){
            for(int col:columns){
                ChessPiece space = getPiece(row,col);
                if(space != null){
                    onBoard.add(space);
                }
            }
        }
        return(onBoard);
    }

    public static ChessPiece getKing(char color){
        if(color == 'w'){
            return(getPiece(kings[0],kings[1]));
        }
        return(getPiece(kings[2],kings[3]));
    }
}
