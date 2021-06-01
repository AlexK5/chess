public class Rook extends Piece implements ChessPiece {

    public Rook(int rowNum, int colNum, char colorChar) throws Exception{
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
        if((getRow() != row && getColumn() != col) || (getRow() == row && getColumn() == col)){
            return(false);
        }else{
            if(getRow() == row){
                int[] between = new int[Math.abs(getColumn()-col)-1];
                boolean left = getColumn() > col;
                for(int i = 0; i < between.length; i++){
                    if(left){
                        between[i] = getColumn() - i - 1;
                    }else{
                        between[i] = getColumn() + i + 1;
                    }
                }
                for(int j:between) {
                    if (Board.getPiece(getRow(), j) != null) {
                        return (false);
                    }
                }
            }else{
                int[] between = new int[Math.abs(getRow()-row)-1];
                boolean down = getRow() > row;
                for(int i = 0; i < between.length; i++){
                    if(down){
                        between[i] = getRow() - i - 1;
                    }else{
                        between[i] = getRow() + i + 1;
                    }
                }
                for(int j:between){
                    if(Board.getPiece(j, getColumn()) != null){
                        return(false);
                    }
                }
            }
            return Board.getColor(row, col) != getColor();
        }
    }
}
