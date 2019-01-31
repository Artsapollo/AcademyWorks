package Lesson13;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author spasko
 */
@XmlRootElement(name = "teacher")
public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String surname, int yearOfBorn, int salary) {
        super(name, surname, yearOfBorn);
        this.salary = salary;
    }

    public Teacher() {
        super();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    @JsonValue
    public String toString() {
        return "Teacher [salary=" + salary + " " + super.toString() + "]";
    }

}