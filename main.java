public class main {
    public static void main(String[] args) throws Exception {
        Board board = new Board(8,8);
        Queen q1 = new Queen(5,3,'b');
        Rook r1 = new Rook(4,2,'w');
        System.out.println(q1.canMove(4,2));
    }
}
