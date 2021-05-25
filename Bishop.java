public class Bishop implements ChessPiece {
    private int rank = -1;
    private int file = -1;
    private char color = 'n';

    public Bishop(int rowNum, int colNum, char colorChar) throws Exception{
        if(rowNum >= 0 && rowNum <= 7 && colNum >= 0 && colNum <= 7){
            rank = rowNum;
            file = colNum;
            color = colorChar;
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
        if(Math.abs(rank-row) != Math.abs(file-col)){
            return(false);
        }else{
            if(rank-row == file-col){
                int[][] between = new int[Math.abs(file-col)-1][2];
                boolean downleft = file > col;
                for(int i = 0; i < between.length; i++){
                    if(downleft){
                        between[i][0] = rank - i - 1;
                        between[i][1] = file - i - 1;
                    }else{
                        between[i][0] = rank + i + 1;
                        between[i][1] = file + i + 1;
                    }
                }
                for(int[] j:between){
                    if(Board.getPiece(j[0], j[1]) != null){
                        return(false);
                    }
                }
            }else{
                int[][] between = new int[Math.abs(file-col)-1][2];
                boolean upleft = file > col;
                for(int i = 0; i < between.length; i++){
                    if(upleft){
                        between[i][0] = rank + i + 1;
                        between[i][1] = file - i - 1;
                    }else{
                        between[i][0] = rank - i - 1;
                        between[i][1] = file + i + 1;
                    }
                }
                for(int[] j:between){
                    if(Board.getPiece(j[0], j[1]) != null){
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
