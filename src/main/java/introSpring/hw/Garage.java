package introSpring.hw;

public abstract class Garage implements Car{
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getColor() {
        return this.getColor();
    }

    @Override
    public String toString() {
        return "Garage [Car name = " + getName() + ", Color = " + getColor() + "]";
    }
}
