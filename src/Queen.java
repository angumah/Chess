public class Queen extends Piece implements ChessPiece{
    int row;
    int col;
    int player;

    public Queen(int row, int col, int player){
        super(row, col, player);
    }

    public boolean canMove(int row, int col){
        if(row >= 8 || col >= 8 || (row == this.row && col == this.col)){
            return false;
        }
        Piece piece = ChessGame.getPiece(row, col);


        //move like rook
        if(row == this.row || col == this.col){
            if(row == this.row){
                int cAdd = col > this.col ?
                        1 : -1;
                int checkC = this.col;

                while(true) {
                    checkC += cAdd;
                    boolean hasPiece = ChessGame.hasPiece(this.row, checkC);
                    if (hasPiece) {
                        return false;
                    }
                    if(checkC == col -1){
                        break;
                    }
                }

            }
            if(col == this.col){
                int rAdd = row > this.row ?
                        1 : -1;
                int checkR = this.row;

                while(true) {
                    checkR += rAdd;
                    boolean hasPiece = ChessGame.hasPiece(checkR, this.col);
                    if (hasPiece) {
                        return false;
                    }
                    if(checkR == row -1){
                        break;
                    }
                }

            }
            if(piece == null){
                return true;
            }
            if(piece.getPlayer() == this.player){
                return false;
            } else {
                return true;
            }
        }
        //move like bishop
        int deltaR = row > this.row ?
                row - this.row : this.row - row;

        int deltaC = col > this.col ?
                col - this.col : this.col - col;

        double slope = deltaR / deltaC;


        if (slope == 1) {
            int rAdd = row > this.row ?
                    1 : -1;
            int cAdd = col > this.col ?
                    1 : -1;

            int checkR = this.row;
            int checkC = this.col;

            while (true) {
                checkR += rAdd;
                checkC += cAdd;

                boolean hasPiece = ChessGame.hasPiece(checkR, checkC);
                if (hasPiece) {
                    return false;
                }
                if(checkC == col-1 && checkR == row-1){
                    break;
                }
            }

            if (piece == null) {
                return true;
            }
            if (piece.getPlayer() == this.player) {
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
