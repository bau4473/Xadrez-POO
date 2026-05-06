public class Queen extends Piece {

  public Queen(int x, int y, Player player) {
    super(x, y, player);
    this.type = Type.QUEEN;
  }

  @Override
  public boolean isValid(int x, int y) {
    if (Math.abs(x - this.x) == Math.abs(y - this.y) || this.x == x && this.y != y || this.y == y && this.x != x) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canJump() {
    return false;
  }
}
