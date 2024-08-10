import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Board board = new Board();
    board.initBoard();

    UniformCostSearch UCS = new UniformCostSearch(board);

    ArrayList<Board> path = UCS.search();
    if (path != null) {
      for (Board b : path) {
        b.printBoard();
      }
    }
  }
}
