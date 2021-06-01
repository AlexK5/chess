public class main {
    public static void main(String[] args) throws Exception {
        Board board = new Board(8,8);
        Bishop b1 = new Bishop(5,3,'b');
        b1.attemptMove(4,4);
        Bishop b2 = new Bishop(5,7,'w');
        System.out.println(b1.canKill(b2));
    }
}
