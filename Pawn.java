public class Pawn implements ChessPiece {
    private int rank = -1;
    private int file = -1;
    private char color = 'n';

    public Pawn(int rowNum, int colNum, char colorChar) throws Exception{
        if(rowNum >= 0 && rowNum <= 7 && colNum >= 0 && colNum <= 7){
            rank = rowNum;
            file = colNum;
            color = colorChar;
            Board.addPiece(this, color);
        }else{
            throw new Exception("ERROR: row and column numbers must be between 0 and 7 inclusive.");
        }
    }

    public int getRow(){
        return(rank);
    }

    public int getColumn(){
        return(file);
    }

    public boolean canMove(int row, int col){
        if(rank == row && file == col){
            return(false);
        }
        int forward = 1;
        char opp = 'b';
        if(color == 'b') {
            forward = -1;
            opp = 'w';
        }
        if(row - rank == forward && file == col){
            return(Board.getColor(row, col) == 'n');
        }
        if(row - rank == 2 * forward && file == col){
            if(Board.getColor(rank + forward, col) != 'n'){
                return(false);
            }
            return(Board.getColor(row, col) == 'n');
        }
        if(row - rank == forward && Math.abs(file - col) == 1){
            return(Board.getColor(row,col) == opp);
        }
        return(false);
    }

    public boolean canKill(ChessPiece piece){
        return(Board.getColor(piece.getRow(),piece.getColumn()) != color && canMove(piece.getRow(),piece.getColumn()));
    }

    public void attemptMove(int row, int col){
        if(canMove(row,col)){
            Board.move(rank, file, row, col);
            rank = row;
            file = col;
        }
    }
}
