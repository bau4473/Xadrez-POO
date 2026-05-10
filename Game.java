import java.util.Scanner;

public class Game {
  private Board board;
  private Player white;
  private Player black;
  private Player currentPlayer = null;
  private Boolean gameover = false;

  public Game(Player white, Player black) {
    this.white = white;
    this.black = black;
    this.board = new Board();
    this.board.setupDefaultBoard(white, black);
    this.currentPlayer = white;
  }

  public Board getBoard() {
    return board;
  }

  public int[] parseInputUser(String input) {
    int row;
    int column;

    row = input.charAt(1);
    column = input.charAt(0);

    int[] coordinates = new int[2];
    coordinates[0] = row - '1';
    coordinates[1] = column - 'a';

    return coordinates;
  }

  public void playerTurn() {
    Scanner sc = new Scanner(System.in);
    while (!gameover) {

      String selectedPiece = sc.nextLine();
      int[] coordinates = new int[2];
      coordinates = parseInputUser(selectedPiece);
      Piece piece = board.getPiece(coordinates[0], coordinates[1]);

      if (piece == null) {

        continue;
      } else if (piece.player.playerColor != currentPlayer.playerColor) {

        continue;
      }

      String destined = sc.nextLine();

      coordinates = parseInputUser(destined);

      if (piece.isValid(coordinates[0], coordinates[1])
          && board.isPathClear(piece.getX(), piece.getY(), coordinates[0], coordinates[1])
          && !board.isAlly(coordinates[0], coordinates[1], currentPlayer)) {
        board.movePiece(piece.getX(), piece.getY(), coordinates[0], coordinates[1]);
        if (currentPlayer == white) {
          currentPlayer = black;
        } else {
          currentPlayer = white;
        }
      } else {
        // movimento invalido
      }
    }
  }

}
