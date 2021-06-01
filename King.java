public class King extends Piece implements ChessPiece {

    public King(int rowNum, int colNum, char colorChar) throws Exception{
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

    public boolean canMove(int row, int col){
        if(getRow() == row && getColumn() == col) {
            return (false);
        }
        int rowDif = Math.abs(getRow()-row);
        int colDif = Math.abs(getColumn()-col);
        if(rowDif + colDif > 2 || Math.abs(rowDif - colDif) > 1){
            return(false);
        }
        return Board.getColor(row, col) != getColor();
    }
}

