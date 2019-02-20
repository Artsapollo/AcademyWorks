package Lesson21.proxy;

public class RealImage implements Image {
    private String file;

    public RealImage(String file) {
        this.file = file;
        load(file);
    }

    public void load(String file) {
        System.out.println("Downloading..." + file);
    }

    public void display() {
        System.out.println("Review " + file);
    }

}
