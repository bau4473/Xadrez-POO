public class Pawn extends Piece {

  public Pawn(int x, int y, Player player) {
    super(x, y, player);
    this.type = Type.PAWN;
  }

  @Override
  public boolean isValid(int x, int y) {
    if (this.player.playerColor == Color.WHITE) {
      if (x - this.x == 1 && y == this.y || x - this.x == 2 && y == this.y && this.x == 1) {
        return true;
      } else {
        return false;
      }
    } else {
      if (this.player.playerColor == Color.BLACK) {
        if (x - this.x == -1 && y == this.y || x - this.x == -2 && y == this.y && this.x == 6) {
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }

  @Override
  public boolean canJump() {
    return false;
  }

}
