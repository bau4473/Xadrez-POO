public abstract class Piece {
  // Atributos
  protected int x;
  protected int y;
  protected Player player;
  protected Type type;

  //teste de push
  // Construtor
  public Piece(int x, int y, Player player) {
    this.x = x;
    this.y = y;
    this.player = player;
  }

  public Piece(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // Metodos
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Player getPlayer() {
    return player;
  }

  public void setX(int value) {
    x = value;
  }

  public void setY(int value) {
    y = value;
  }

  public void setPlayer(Player value) {
    player = value;
  }

  public Type getType() {
    return type;
  }

  public abstract boolean isValid(int x, int y);

  public abstract boolean canJump();
}
