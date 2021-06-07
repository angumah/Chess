public class ChessGame {
    private static Piece[][] pieces;
    private final int maxRow = 8;
    private final int maxCol = 8;
    public ChessGame(){
        pieces = new Piece[maxRow][maxCol];
    }

    public void initPieces() {
        int player = 0;

        //initializes for first player
            for (int i = 0; i < maxRow; i++) {
                switch (i) {
                    case 0:
                        for (int k = 0; k < maxCol; k++) {
                            switch (k) {
                                case 0, 7:
                                    pieces[i][k] = new Rook(i, k, player); break;
                                case 1, 6:
                                    pieces[i][k] = new Knight(i, k, player); break;
                                case 2, 5:
                                    pieces[i][k] = new Bishop(i, k, player); break;
                                case 3:
                                    pieces[i][k] = new King(i, k, player); break;
                                case 4:
                                    pieces[i][k] = new Queen(i, k, player); break;
                            }
                        } break;

                    case 1:
                        for (int k = 0; k < maxCol; k++){
                            pieces[i][k] = new Pawn(i, k, player);
                        } break;
                }
            }


            //initializes for second player

        player = 1;
        for (int i = maxRow-1; i >= 0; i--) {
            switch (i) {
                case 6:
                    for (int k = 0; k < maxCol; k++){
                        pieces[i][k] = new Pawn(i, k, player);
                    } break;

                case 7:
                    for (int k = 0; k < maxCol; k++) {
                        switch (k) {
                            case 0, 7:
                                pieces[i][k] = new Rook(i, k, player); break;
                            case 1, 6:
                                pieces[i][k] = new Knight(i, k, player); break;
                            case 2, 5:
                                pieces[i][k] = new Bishop(i, k, player); break;
                            case 3:
                                pieces[i][k] = new King(i, k, player); break;
                            case 4:
                                pieces[i][k] = new Queen(i, k, player); break;
                        }
                    } break;


            }
        }
    }



    public static Piece getPiece(int row, int column){
        Piece checkPiece = null;
        int length = pieces.length;
        for(int r = 0; r < length; r++){
            for(int c = 0; c < pieces[r].length; c++){
                if (r == row && c == column){
                    checkPiece = pieces[r][c];
                }
            }
        }
        return checkPiece;
    }

    public static boolean hasPiece(int row, int column){
        Piece checkPiece = null;
        int length = pieces.length;
        for(int r = 0; r < length; r++){
            for(int c = 0; c < pieces[r].length; c++){
                if (r == row && c == column){
                    checkPiece = pieces[r][c];
                    if(checkPiece != null){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ChessGame test = new ChessGame();
        test.initPieces();
    }
}

