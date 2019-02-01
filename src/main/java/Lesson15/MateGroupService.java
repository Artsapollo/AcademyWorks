package Lesson15;

import Lesson13.Person;

import javax.ws.rs.core.Response;


/**
 * @author spasko
 */

public interface MateGroupService {

    public Response getMateGroup(int groupId);

    public Response addStudents(int groupId, Person person);

    public Response removeStudent(int groupId, String surname);

    public Response addNameStudent(int groupId, String surname, String name);
}