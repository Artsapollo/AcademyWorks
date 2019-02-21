package Lesson21.proxy;

public class Proxy {
    public static void main(String[] args) {
        Image image1 = new RealImage("test.jpg");
        image1.display();
        System.out.println();

        Image image = new ProxyImage("test.jpg");
        image.display();
    }
}
