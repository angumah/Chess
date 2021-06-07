public class Piece {
    private int row;
    private int col;
    private int player;
    public Piece(int row, int col, int player){
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.col;
    }

    public int getPlayer(){
        return this.player;
    }
    public void print(){
        System.out.println(this.row);
        System.out.println(this.col);
        System.out.println(this.player);
    }
}
