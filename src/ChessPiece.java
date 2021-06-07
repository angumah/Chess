public interface ChessPiece {

    public boolean canMove(int row, int col);
    public boolean canKill(Piece piece);
}
