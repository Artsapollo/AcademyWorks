package Lesson10.SemaphoreTesting;

public class Resurs {
    private int value = 0;

    public Resurs(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }
}
