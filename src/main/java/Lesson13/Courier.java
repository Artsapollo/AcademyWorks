package Lesson13;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Courier extends Person {
    @XmlAttribute
    private int tips;

    public Courier(String name, String surname, int yearOfBorn, int tips){
       super(name,surname,yearOfBorn);
        this.tips = tips;
    }

    public Courier(){

    }

    public String getName(){
        return super.getName();
    }

    public int getTips() {
        return tips;
    }

    public void setTips(int tips) {
        this.tips = tips;
    }

    @Override
    @JsonValue
    public String toString() {
        return "Courier [tips= " + tips + " " + super.toString() + "]";
    }
}
