package lesson14.REST;

import lesson13.Person;
import lesson13.Teacher;

import javax.ws.rs.core.Response;

public interface MateGroupService {

     Response addStudents(int groupId, Person person);

     Response changeTeacher(int groupId, Teacher teacher);
}
