package Lesson4_1;

import java.util.*;

public class Player6 implements PlayAllSongs{
    final int price;
    String[] playList = new String[6];

    public Player6(int price, String[] playList) {
        this.price = price;
        this.playList = playList;
    }


    public int getPrice() {
        return 6;
    }


    public void playSong() {
        System.out.println("Playing: " + playList[0]);
    }


    public void playAllSongs() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Playing: " + playList[i]);
        }
    }

    public void shuffle(String [] playList){
        List<String> list = Arrays.asList(playList);
        Collections.shuffle(list);
    }
}