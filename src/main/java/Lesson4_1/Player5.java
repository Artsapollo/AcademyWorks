package Lesson4_1;

public class Player5 implements PlayAllSongs {
    final int price;
    String[] playList = new String[5];

    public Player5(int price, String[] playList) {
        this.price = price;
        this.playList = playList;
    }


    public int getPrice() {
        return 5;
    }


    public void playSong() {
        System.out.println("Playing: " + playList[0]);
    }


    public void playAllSongs() {
        for (int i = 5; i >= 0; i--) {
            System.out.println("Playing: " + playList[i]);
        }
    }
}
