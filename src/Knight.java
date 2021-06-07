public class Knight extends Piece implements ChessPiece{
    int row;
    int col;
    int player;

    public Knight(int row, int col, int player){
        super(row, col, player);
    }

    public boolean canMove(int row, int col){
        if(row >= 8 || col >= 8 || row == this.row || col == this.col){
            return false;
        }

        Piece piece = ChessGame.getPiece(row, col);

        int deltaR = row > this.row ?
                row-this.row : this.row - row;

        int deltaC = col > this.col ?
                col-this.col : this.col - col;

        if((deltaR == 2 && deltaC == 1) || (deltaR == 1 && deltaC == 2)){
            if(piece == null){
                return false;
            }
            if(piece.getPlayer() == this.player){
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean canKill(Piece piece){
        int row = piece.getRow();
        int col = piece.getColumn();
        return canMove(row, col);
    }
}
