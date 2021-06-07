public class King extends Piece implements ChessPiece {
    int row;
    int col;
    int player;

    public King(int row, int col, int player){
        super(row, col, player);
    }

    public boolean canMove(int row, int col ){
        if(row >= 8 || col >= 8 || (this.row == row && this.col == col)){
            return false;
        }
        Piece piece = ChessGame.getPiece(row, col);
        if(this.row == row || this.col == col){
            if(col != this.col){
                if(Math.abs(col - this.col)== 1){
                    if(piece == null){
                        return true;
                    }
                    if(piece.getPlayer() == this.player){
                        return false;
                    } else {return true;}
                }
            }
            if(row != this.row){
                if(piece == null){
                    return true;
                }
                if(piece.getPlayer() == this.player){
                    return false;
                } else {return true;}
            }
        } else {
            if((Math.abs(row - this.row)/Math.abs(col-this.col)) == 1){
                if(piece == null){
                    return true;
                }
                if(piece.getPlayer() == this.player){
                    return false;
                } else {return true;}
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
