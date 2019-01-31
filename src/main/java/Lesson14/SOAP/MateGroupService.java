package Lesson14.SOAP;

import Lesson13.MateGroup;
import Lesson13.Person;
import Lesson13.Teacher;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface MateGroupService {

    @WebMethod
    public MateGroup getMateGroup();

    @WebMethod
    public MateGroup addStudent(List<Person> persons);

    @WebMethod
    MateGroup changeTeacher(Teacher teacher);


}
