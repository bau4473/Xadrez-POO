public class Main {
  public static void main(String[] args) {
    Player white = new Player(Color.WHITE);
    Player black = new Player(Color.BLACK);
    Game chessMatch = new Game(white, black);
    chessMatch.playerTurn();
  }
}
