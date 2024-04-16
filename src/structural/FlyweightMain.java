package structural;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 15:44
 * @description: structural
 * @version: 1.0
 */
public class FlyweightMain {
    public static void main(String[] args) {
        PieceFactory pieceFactory = new PieceFactory();
        Piece piece = pieceFactory.getPiece(1);
        System.out.println(piece);
        Piece piece1 = pieceFactory.getPiece(0);
        System.out.println(piece1);
        Piece piece2 = pieceFactory.getPiece(1);
        System.out.println(piece2);
        Piece piece3 = pieceFactory.getPiece(0);
        System.out.println(piece3);

    }
}


class PieceFactory{
    private Piece[] pieces = {new WhitePiece(), new BlankPiece()};
    public Piece getPiece(int key){
        if(key ==0) return pieces[0];
        else return pieces[1];
    }

}

abstract class Piece{
    protected String color;
    public abstract void draw(int x, int y);

}

class WhitePiece extends Piece{
    public WhitePiece(){
        this.color = "white";
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color : " + color + "piece x:"+ x + "y : "+y);
    }
}

class BlankPiece extends Piece{
    public BlankPiece(){
        this.color = "blank";
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color : " + color + "piece x:"+ x + "y : "+y);
    }
}
