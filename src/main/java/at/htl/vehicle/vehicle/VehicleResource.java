package at.htl.vehicle.vehicle;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("vehicles")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleRepository repo;

    @Inject
    VehicleMapper vehicleMapper;

    @GET
    @Path("{id}")
    public VehicleDto find(@PathParam("id") long id) {
        //return vehicleMapper.fromEntity(repo.find(id));
        return vehicleMapper.fromEntity(repo.find(id));
    }

    @GET
    @Path("")
    public List<VehicleDto> find() {
        var vehicles = repo.findAll();
        return vehicles.stream().map(v -> vehicleMapper.fromEntity(v)).toList();
        //return vehicles.stream().map(vehicleMapper::fromEntity).toList();
    }
}
