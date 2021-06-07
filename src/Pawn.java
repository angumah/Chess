public class Pawn extends Piece implements ChessPiece{
    int row;
    int col;
    int player;
    boolean firstMove;

    public Pawn(int row, int col, int player){
        super(row, col, player);
        firstMove = true;
    }

    public boolean canMove(int row, int col) {
        if (row >= 8 || col >= 8 || (col == this.col && row == this.row) || (Math.abs(this.row - row) > 2)) {
            return false;
        }


        switch (this.player) {
            case 0:
                if (row > this.row) {
                    int checkR = this.row;
                    if (Math.abs(row - this.row) == 1 || (firstMove && Math.abs(row - this.row) == 2)) {
                        while (true) {
                            checkR += 1;
                            if (ChessGame.hasPiece(checkR, this.col)) {
                                return false;
                            }
                            if (checkR == row - 1) {
                                break;
                            }
                        }
                    }
                } else {
                    return false;
                }
                break;
            case 1:
                int checkR = this.row;
                if (Math.abs(row - this.row) == 1 || (firstMove && Math.abs(row - this.row) == 2)) {
                    while (true) {
                        checkR -= 1;
                        if (ChessGame.hasPiece(checkR, this.col)) {
                            return false;
                        }
                        if (checkR == row - 1) {
                            break;
                        }
                    }
                } else {
                    return false;
                }
                break;
        }
        return false;
    }

    public boolean canKill(Piece piece){
        Piece leftPiece = ChessGame.getPiece(this.row+1, this.col -1);
        Piece rightPiece = ChessGame.getPiece(this.row+1, this.col +1);

        if(leftPiece != null){
            if(leftPiece == piece && leftPiece.getPlayer() != this.player){
                return true;
            }
        }
        if(rightPiece != null){
            if(rightPiece == piece && rightPiece.getPlayer() != this.player){
                return true;
            }
        }
        return false;
    }
}
