package lesson21.proxy;

public class ProxyImage implements Image {
    private String file;
    private RealImage image;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        System.out.println("Through the proxy");
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}
