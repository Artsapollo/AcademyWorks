package Lesson14.REST;

import Lesson13.Person;

import javax.ws.rs.core.Response;

public interface MateGroupService {
    public javax.ws.rs.core.Response getMateGroup();

    public Response addStudents(int groupId, Person person);
}
