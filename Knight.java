public class Knight implements ChessPiece {
    private int rank = -1;
    private int file = -1;
    private char color = 'n';

    public Knight(int rowNum, int colNum, char colorChar) throws Exception{
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
        if(rank == row && file == col) {
            return (false);
        }
        int rowDif = Math.abs(rank-row);
        int colDif = Math.abs(file-col);
        if(rowDif + colDif != 3 || Math.abs(rowDif - colDif) != 1){
            return(false);
        }
        return Board.getColor(row, col) != color;
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
