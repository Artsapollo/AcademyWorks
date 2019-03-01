package lesson14.SOAP;

import lesson13.Person;
import lesson13.Student;
import lesson13.Teacher;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MateGroupServiceClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/mate?wsdl");

        // 1st argument service URI, refer to wsdl document above
        // 2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://lesson14/SOAP/", "MateGroupServiceImplService");

        Service service = Service.create(url, qname);

        MateGroupService hello = service.getPort(MateGroupService.class);

        System.out.println(hello.getMateGroup());

        List<Person> persons = new ArrayList<>();
        persons.add(new Student("Student", "ConnectToDB", 1995));
        persons.add(new Teacher("Teacher", "Second", 1990, 666));
        System.out.println(hello.changeTeacher(new Teacher("AnotherTeacher", "Surname", 1984, 1000)));
        System.out.println(hello.addStudent(persons));

    }

}