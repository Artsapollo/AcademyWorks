package lesson4_1;

public class Player3 implements PlayAllSongs {

    final int price;

    String[] playList = new String[3];

    public Player3(int price, String[] playList) {
        this.price = price;
        this.playList = playList;
    }


    public int getPrice() {
        return 3;
    }


    public void playSong() {
        System.out.println("Playing: " + playList[0]);
    }


    public void playAllSongs() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Playing: " + playList[i]);
        }
    }

}
