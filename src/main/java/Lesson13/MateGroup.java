package Lesson13;

/**
 * @author spasko
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "MateGroup", name = "MateAcademy")
@JsonPropertyOrder({"room", "teacher", "students", "humanResources", "courier"})
public class MateGroup implements Serializable {
    @XmlElement(type = Teacher.class)
    private Person teacher;

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
    @JsonSubTypes({@JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
            @JsonSubTypes.Type(value = Student.class, name = "student")})
    private List<Person> students;

    @XmlElement(required = true, nillable = false)
    private Room room;

    @XmlElementWrapper(name = "hrs")
    @XmlElement(name = "humanResource")
    private Set<HumanResource> humanResources;

    @XmlElement(type = Courier.class)
    private Person courier;
    @XmlAttribute
    private int id;

    public MateGroup(Teacher teacher, List<Person> students, Room room, Set<HumanResource> humanResources, Courier courier) {
        this.teacher = teacher;
        this.students = students;
        this.room = room;
        this.humanResources = humanResources;
        this.courier = courier;
    }

    public MateGroup() {
    }

    public Person getTeacher() {
        return teacher;
    }

    @XmlElement
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<HumanResource> getHumanResources() {
        return humanResources;
    }

    public void setHumanResources(Set<HumanResource> humanResources) {
        this.humanResources = humanResources;
    }

    public Person getCourier() {
        return courier;
    }

    public void setCourier(Person courier) {
        this.courier = courier;
    }

    @Override
    public String toString() {
        return "MateGroup [teacher=" + teacher + ", students=" + students + ", room=" + room + ", humanResources="
                + humanResources + "] " + " Pizza is here! " + courier + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static MateGroup mateGroupExampleCreator() {
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        MateGroup mateGroup = new MateGroup();
        mateGroup.setId(18122018);

        Teacher teacher = new Teacher("Serhii", "Pasko", 1988, 666);
        mateGroup.setTeacher(teacher);

        Courier courier = new Courier("Pablo","Skoropadskuy",1988,50);
        mateGroup.setCourier(courier);

        Room room = new Room("Kyiv", "Tarasivska", 16, 28);
        mateGroup.setRoom(room);

        Set<HumanResource> humanResources = new HashSet<>();
        humanResources.add(new HumanResource("Karmen", "", 1990, 2015));
        humanResources.add(new HumanResource("Efiria", "", 1989, 2016));
        mateGroup.setHumanResources(humanResources);

        List<Person> students = new ArrayList<>();
        students.add(new Student("Iza", "Rabinovish", 1997));
        students.add(new Student("Abram", "Kolom", 1998));
        students.add(new Student("Moisha", "Stefan", 1990));
        mateGroup.setStudents(students);

        return mateGroup;
    }

}