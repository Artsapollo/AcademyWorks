package Lesson4_1;

public class Player4 implements PlayAllSongs {

    final int price;

    String[] playList = new String[4];

    public Player4(int price, String[] playList) {
        this.price = price;
        this.playList = playList;
    }


    public int getPrice() {
        return 4;
    }


    public void playSong() {
        System.out.println("Playing: " + playList[3]);
    }


    public void playAllSongs() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Playing: " + playList[i]);
        }
    }
}
