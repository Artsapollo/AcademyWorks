package Lesson14.REST;

import Lesson13.Person;
import Lesson13.Teacher;

import javax.ws.rs.core.Response;

public interface MateGroupService {

     Response addStudents(int groupId, Person person);

     Response changeTeacher(int groupId, Teacher teacher);
}
