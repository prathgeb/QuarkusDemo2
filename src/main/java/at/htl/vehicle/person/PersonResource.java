package at.htl.vehicle.person;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("person")
public class PersonResource {
    @Inject
    PersonRepository repo;

    @Inject PersonMapper personMapper;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDto find(@PathParam("id") long id) {
        return personMapper.fromEntity(repo.findById(id));
    }

}
