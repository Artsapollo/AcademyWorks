package lesson4_1;

public class Player1 implements PlaySong{
    String song;
    final int price;

    public Player1(String song, int price) {
        this.song = song;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public String getSong() {
        return song;
    }


    public void playSong() {
        System.out.println("Playing: " + getSong() + "\n");
    }
}
