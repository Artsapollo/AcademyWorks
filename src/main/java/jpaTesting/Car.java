package jpaTesting;

import java.util.Date;

public class Car {
    private String name;
    private Date releaseDate;
    private float cost;

    public Car(String name, Date releaseDate, float cost) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", cost=" + cost +
                '}';
    }
}
