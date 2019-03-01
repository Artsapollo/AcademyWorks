package lesson14.REST;

import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import lesson13.MateGroup;
import lesson13.Person;
import lesson13.Teacher;

import static javax.ws.rs.core.Response.Status.ACCEPTED;
import static sun.security.timestamp.TSResponse.BAD_REQUEST;

@Path("/rs/mate")
public class MateGroupServiceImpl implements MateGroupService {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup() {
        return Response.status(Status.OK).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @PUT
    @Path("/{groupId}/Student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
        if (groupId == mateGroup.getId()) {
            mateGroup.getTeacher().setYearOfBorn(1984);
            return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }


    @PUT
    @Path("/{groupId}/Teacher")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeTeacher(@PathParam("groupId") int groupId, Teacher teacher) {
        if (teacher == null || groupId != mateGroup.getId()) {
            return Response.status(BAD_REQUEST).build();
        }
        mateGroup.setTeacher(teacher);
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }
}

