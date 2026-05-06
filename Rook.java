public class Rook extends Piece {

  public Rook(int x, int y, Player player) {
    super(x, y, player);
    this.type = Type.ROOK;
  }

  @Override
  public boolean isValid(int x, int y) {
    if (this.x == x && this.y != y || this.y == y && this.x != x) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canJump() {
    return false;
  }
}
