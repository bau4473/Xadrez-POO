public class Bishop extends Piece {

  public Bishop(int x, int y, Player player) {
    super(x, y, player);
    this.type = Type.BISHOP;
  }

  @Override
  public boolean isValid(int x, int y) {
    if (Math.abs(x - this.x) == Math.abs(y - this.y)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canJump() {
    return false;
  }
}
