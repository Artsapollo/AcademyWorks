package lesson13;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author spasko
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Student extends Person {

    @Override
    @XmlTransient
    @JsonIgnore
    @JsonValue
    public String getSurname() {
        return super.getSurname();
    }

    public Student() {

    }

    public Student(String name, String surname, int yearOfBorn) {
        super(name, surname, yearOfBorn);
    }

}