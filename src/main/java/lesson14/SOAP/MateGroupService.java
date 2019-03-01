package lesson14.SOAP;

import lesson13.MateGroup;
import lesson13.Person;
import lesson13.Teacher;

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
