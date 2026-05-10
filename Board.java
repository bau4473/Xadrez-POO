public class Board {
  public static final int size = 8;
  private Piece[][] grid;

  public Board() {
    grid = new Piece[size][size];
  }

  public boolean isInsideBoard(int row, int column) {
    if (row >= 0 && row <= 7 && column >= 0 && column <= 7) {
      return true;
    }

    return false;
  }

  public Piece getPiece(int row, int column) {
    return grid[row][column];
  }

  public void setPiece(int row, int column, Piece piece) {
    grid[row][column] = piece;
  }

  public void removePiece(int row, int column) {
    grid[row][column] = null;
  }

  public boolean isPathClear(int originRow, int originColumn, int destinedRow, int destinedColumn) {
    if (getPiece(originRow, originColumn).canJump() == true) {
      return true;
    } else {
      int deltaRow = destinedRow - originRow;
      int directionRow;
      if (deltaRow != 0) {
        directionRow = deltaRow / Math.abs(deltaRow);
      } else {
        directionRow = 0;
      }
      int deltaColumn = destinedColumn - originColumn;
      int directionColumn;
      if (deltaColumn != 0) {
        directionColumn = deltaColumn / Math.abs(deltaColumn);
      } else {
        directionColumn = 0;
      }
      int i, j;
      i = originRow + directionRow;
      j = originColumn + directionColumn;
      while (i != destinedRow || j != destinedColumn) {
        if (grid[i][j] != null) {
          return false;
        }
        i += directionRow;
        j += directionColumn;
      }
    }
    return true;
  }

  public void movePiece(int originRow, int originColumn, int destinedRow, int destinedColumn) {
    Piece piece = getPiece(originRow, originColumn);
    setPiece(destinedRow, destinedColumn, piece);
    removePiece(originRow, originColumn);
    piece.setX(destinedRow);
    piece.setY(destinedColumn);
    if (piece instanceof Pawn) {
      Pawn p = (Pawn) piece;
      if (p.canBePromoted()) {
        p.pawnPromotion(piece.player, this);
      }
    }
  }

  public boolean isAlly(int destinedRow, int destinedColumn, Player currentPlayer) {
    Piece piece = getPiece(destinedRow, destinedColumn);
    if (piece == null) {
      return false;
    } else if (piece.player.playerColor == currentPlayer.playerColor) {
      return true;
    }

    return false;
  }

  public void setupDefaultBoard(Player white, Player black) {
    setPiece(0, 0, new Rook(0, 0, white));
    setPiece(0, 1, new Knight(0, 1, white));
    setPiece(0, 2, new Bishop(0, 2, white));
    setPiece(0, 3, new Queen(0, 3, white));
    setPiece(0, 4, new King(0, 4, white));
    setPiece(0, 5, new Bishop(0, 5, white));
    setPiece(0, 6, new Knight(0, 6, white));
    setPiece(0, 7, new Rook(0, 7, white));

    // Brancas - peões fileira 1
    for (int i = 0; i < size; i++) {
      setPiece(1, i, new Pawn(1, i, white));
    }

    // Pretas - fileira 7
    setPiece(7, 0, new Rook(7, 0, black));
    setPiece(7, 1, new Knight(7, 1, black));
    setPiece(7, 2, new Bishop(7, 2, black));
    setPiece(7, 3, new Queen(7, 3, black));
    setPiece(7, 4, new King(7, 4, black));
    setPiece(7, 5, new Bishop(7, 5, black));
    setPiece(7, 6, new Knight(7, 6, black));
    setPiece(7, 7, new Rook(7, 7, black));

    // Pretas - peões fileira 6
    for (int i = 0; i < size; i++) {
      setPiece(6, i, new Pawn(6, i, black));
    }

  }
}
