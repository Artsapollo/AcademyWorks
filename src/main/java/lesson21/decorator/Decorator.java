package lesson21.decorator;

public class Decorator {
    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car muscleCarDecorator = new MuscleCarDecorator(new OldCar());

        sportCar.draw();
        System.out.println();
        muscleCarDecorator.draw();
    }
}
