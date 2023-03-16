package at.htl.vehicle.rental;

import at.htl.vehicle.person.PersonDto;
import at.htl.vehicle.vehicle.VehicleDto;

import java.math.BigDecimal;

public record RentalDto(Long id, VehicleDto vehicle, PersonDto person, long start, long end, double discount) {

}
