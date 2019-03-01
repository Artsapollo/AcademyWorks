package lesson21.decorator;

public class MuscleCarDecorator extends CarDecorator{

    public MuscleCarDecorator(Car decorated) {
        super(decorated);
    }

    @Override
    public void draw() {
        decorated.draw();
        setCarType();
    }

    private void setCarType() {
        System.out.println("Now it's muscle car");
    }

}
