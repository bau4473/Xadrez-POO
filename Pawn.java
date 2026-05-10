import java.util.Scanner;

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

  public boolean canBePromoted(){
    if (this.y == 0 || this.y == 7) return true;
    return false;
  }
  
  public void pawnPromotion(Player player, Board board){
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      System.out.println("Escolha uma peça ser promovida (R, N, Q, B)");
      char choice = sc.next().charAt(0);
      switch (choice) {
        case 'R':
          board.setPiece(this.x, this.y, new Rook(this.x, this.y, player));
          flag = false;
          break;
        case 'N':
          board.setPiece(this.x, this.y, new Knight(this.x, this.y, player));
          flag = false;
          break;
        case 'Q':
          board.setPiece(this.x, this.y, new Queen(this.x, this.y, player));
          flag = false;
          break;
        case 'B':
          board.setPiece(this.x, this.y, new Bishop(this.x, this.y, player));
          flag = false;
          break;
        default:
          System.out.println("Peça invalida");
      }
    }
    sc.close();
  }
}
