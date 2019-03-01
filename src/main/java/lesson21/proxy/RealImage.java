package lesson21.proxy;

public class RealImage implements Image {
    private String file;

    public RealImage(String file) {
        this.file = file;
        load(file);
    }

    public void load(String file) {
        System.out.println("Downloading " + file);
    }

    @Override
    public void display() {
        System.out.println("Showing " + file);
    }

}
