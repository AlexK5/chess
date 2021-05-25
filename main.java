public class main {
    public static void main(String[] args) throws Exception {
        Board board = new Board(8,8);
        Bishop b1 = new Bishop(5,3,'w');
        Rook r1 = new Rook(5,2,'w');
        System.out.println(b1.canMove(7,1));
    }
}
