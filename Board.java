public class Board {
    private static int[] rows;
    private static int[] columns;
    private static ChessPiece[][] pieces;
    private static char[][] colors;

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

    public static void addPiece(ChessPiece piece, char color){
        pieces[piece.getRow()][piece.getColumn()] = piece;
        colors[piece.getRow()][piece.getColumn()] = color;
    }
}
