package at.htl.vehicle.rental;

import at.htl.vehicle.person.Person;
import at.htl.vehicle.person.PersonDto;
import at.htl.vehicle.person.PersonMapper;
import at.htl.vehicle.vehicle.VehicleMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.ZoneOffset;

@ApplicationScoped
public class RentalMapper {
    @Inject
    VehicleMapper vehicleMapper;

    @Inject
    PersonMapper personMapper;

    public RentalDto fromEntity(Rental r) {
        return new RentalDto(
                r.getId(),
                vehicleMapper.fromEntity(r.getVehicle()),
                personMapper.fromEntity(r.getPerson()),
                r.getStartDateTime().toEpochSecond(ZoneOffset.UTC) * 1000,
                r.getEndDateTime().toEpochSecond(ZoneOffset.UTC) * 1000,
                r.getDiscount().doubleValue());
    }
}
