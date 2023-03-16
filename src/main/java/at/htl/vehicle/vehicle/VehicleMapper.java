package at.htl.vehicle.vehicle;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VehicleMapper {
    public VehicleDto fromEntity(Vehicle v) {
        return new VehicleDto(v.getId(), v.getModel(), v.getBrand());
    }
}
