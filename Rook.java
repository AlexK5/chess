public class Rook implements ChessPiece{
    private int rank = -1;
    private int file = -1;
    private char color = 'n';

    public Rook(int rowNum, int colNum, char colorChar) throws Exception{
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
        if((rank != row && file != col) || (rank == row && file == col)){
            return(false);
        }else{
            if(rank == row){
                int[] between = new int[Math.abs(file-col)-1];
                boolean left = file > col;
                for(int i = 0; i < between.length; i++){
                    if(left){
                        between[i] = file - i - 1;
                    }else{
                        between[i] = file + i + 1;
                    }
                }
                for(int j:between){
                    if(Board.getPiece(rank, j) != null){
                        return(false);
                    }
                }
            }else{
                int[] between = new int[Math.abs(rank-row)-1];
                boolean down = rank > row;
                for(int i = 0; i < between.length; i++){
                    if(down){
                        between[i] = rank - i - 1;
                    }else{
                        between[i] = rank + i + 1;
                    }
                }
                for(int j:between){
                    if(Board.getPiece(j, file) != null){
                        return(false);
                    }
                }
            }
            return Board.getColor(row, col) != color;
        }
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
