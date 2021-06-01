public class Pawn extends Piece implements ChessPiece {

    public Pawn(int rowNum, int colNum, char colorChar) throws Exception{
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
        if(getRow() == row && getColumn() == col){
            return(false);
        }
        int forward = 1;
        char opp = 'b';
        if(super.getColor() == 'b') {
            forward = -1;
            opp = 'w';
        }
        if(row - getRow() == forward && getColumn() == col){
            return(Board.getColor(row, col) == 'n');
        }
        if(row - getRow() == 2 * forward && getColumn() == col && ((getRow() == 2 && getColor() == 'w') || (getRow() == 7 && getColor() == 'b'))){
            if(Board.getColor(getRow() + forward, col) != 'n'){
                return(false);
            }
            return(Board.getColor(row, col) == 'n');
        }
        if(row - getRow() == forward && Math.abs(getColumn() - col) == 1){
            return(Board.getColor(row,col) == opp);
        }
        return(false);
    }
}
