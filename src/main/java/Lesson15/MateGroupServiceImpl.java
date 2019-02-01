package Lesson15;

import Lesson13.MateGroup;
import Lesson13.Person;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @author spasko
 */
@Path("/rs/mate/{groupId}")
public class MateGroupServiceImpl implements MateGroupService {
    private static Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
            .collect(Collectors.toMap(MateGroup::getId, Function.identity()));

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup(@PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            return Response.status(Status.OK).entity(mateGroups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/Student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @Override
    @DELETE
    @Path("/Student/{surname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeStudent(@PathParam("groupId") int groupId, @PathParam("surname")String surname) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().removeIf(f -> f.equals(surname));
            return Response.status(Status.OK).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/Student/{surname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNameStudent(@PathParam("groupId") int groupId, @PathParam("surname")String surname, @QueryParam("name") String name) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().stream().filter(f -> f.getSurname().equals(surname)).forEach(f -> f.setName(name));
            return Response.status(Status.OK).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }
}