public abstract class Piece implements ChessPiece {
    private int rank = -1;
    private int file = -1;
    private char color = 'n';

    public Piece(int rowNum, int colNum, char colorChar){
        rank = rowNum;
        file = colNum;
        color = colorChar;
    }

    public int getRow(){
        return(rank);
    }

    public int getColumn(){
        return(file);
    }

    public char getColor(){
        return(color);
    }

    public void attemptMove(int row, int col){
        if(canMove(row,col)){
            Board.move(rank, file, row, col);
            rank = row;
            file = col;
        }
    }

    public boolean canKill(ChessPiece piece) {
        return (Board.getColor(piece.getRow(), piece.getColumn()) != getColumn() && canMove(piece.getRow(), piece.getColumn()));
    }
}
