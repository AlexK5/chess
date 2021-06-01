public class Bishop extends Piece implements ChessPiece {

    public Bishop(int rowNum, int colNum, char colorChar) throws Exception{
        super(rowNum,colNum, colorChar);
        if(rowNum >= 0 && rowNum <= 7 && colNum >= 0 && colNum <= 7){
            Board.addPiece(this, getColor());
        }else{
            throw new Exception("ERROR: row and column numbers must be between 0 and 7 inclusive.");
        }
    }

    public int getRow(){
        return(super.getRow());
    }

    public int getColumn(){
        return(super.getColumn());
    }

    public char getColor(){
        return(super.getColor());
    }

    public boolean canMove(int row, int col) {
        if (Math.abs(getRow() - row) != Math.abs(getColumn() - col) || (getRow() == row && getColumn() == col)) {
            return (false);
        } else {
            if (getRow() - row == getColumn() - col) {
                int[][] between = new int[Math.abs(getColumn() - col) - 1][2];
                boolean downleft = getColumn() > col;
                for (int i = 0; i < between.length; i++) {
                    if (downleft) {
                        between[i][0] = getRow() - i - 1;
                        between[i][1] = getColumn() - i - 1;
                    } else {
                        between[i][0] = getRow() + i + 1;
                        between[i][1] = getColumn() + i + 1;
                    }
                }
                for (int[] j : between) {
                    if (Board.getPiece(j[0], j[1]) != null) {
                        return (false);
                    }
                }
            } else {
                int[][] between = new int[Math.abs(getColumn() - col) - 1][2];
                boolean upleft = getColumn() > col;
                for (int i = 0; i < between.length; i++) {
                    if (upleft) {
                        between[i][0] = getRow() + i + 1;
                        between[i][1] = getColumn() - i - 1;
                    } else {
                        between[i][0] = getRow() - i - 1;
                        between[i][1] = getColumn() + i + 1;
                    }
                }
                for (int[] j : between) {
                    if (Board.getPiece(j[0], j[1]) != null) {
                        return (false);
                    }
                }
            }
            return Board.getColor(row, col) != getColor();
        }
    }

    public boolean canKill(ChessPiece piece) {
        return (Board.getColor(piece.getRow(), piece.getColumn()) != getColumn() && canMove(piece.getRow(), piece.getColumn()));
    }
}

