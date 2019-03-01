package lesson4_1;

public class Mp3Base {
    public static void main(String[] args) {
        String [] playList = new String []{"Song1","Song2","Song3","Song4","Song5","Song6"};

        Player1 p1 = new Player1("Song1", 1);
        System.out.println("Player1");
        p1.playSong();

        Player2 p2 = new Player2("Song2",2);
        System.out.println("Player2");
        p2.playSong();


        Player3 p3 = new Player3(3,playList);
        System.out.println("Player3");
        p3.playSong();
        System.out.println();
        p3.playAllSongs();
        System.out.println();

        Player4 p4 = new Player4(4,playList);
        System.out.println("Player4");
        p4.playSong();
        System.out.println();
        p4.playAllSongs();
        System.out.println();

        Player5 p5 = new Player5(5,playList);
        System.out.println("Player5");
        p5.playSong();
        System.out.println();
        p5.playAllSongs();
        System.out.println();

        Player6 p6 = new Player6(6,playList);
        System.out.println("Player6");
        p6.playSong();
        System.out.println();
        p6.shuffle(playList);
        p6.playAllSongs();
        System.out.println();
    }
}
