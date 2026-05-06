public class Knight extends Piece {

  public Knight(int x, int y, Player player) {
    super(x, y, player);
    this.type = Type.KNIGHT;
  }

  @Override
  public boolean isValid(int x, int y) {
    if (Math.abs(x - this.x) == 2 && Math.abs(y - this.y) == 1
        || Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == 2) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canJump() {
    return true;
  }
}
