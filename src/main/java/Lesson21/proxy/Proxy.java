package Lesson21.proxy;

public class Proxy {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
        image.display();
    }
}
