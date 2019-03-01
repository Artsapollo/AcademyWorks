package lesson4_1;

public class Player2 extends Player1 implements PlaySong {
    final int price;

    public Player2(String song, int price) {
        super(song, price);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void playSong() {
        System.out.println("error" + "\n");
    }
}
