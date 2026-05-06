public class King extends Piece {

  public King(int x, int y, Player player) {
    super(x, y, player);
    this.type = Type.KING;
  }

  @Override
  public boolean isValid(int x, int y) {
    if (Math.abs(x - this.x) <= 1 && Math.abs(y - this.y) <= 1 && (this.x != x || this.y != y)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canJump() {
    return false;
  }

}
