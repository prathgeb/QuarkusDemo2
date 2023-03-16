package at.htl.vehicle.person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonMapper {
    public PersonDto fromEntity(Person p) {
        return new PersonDto(p.getId(), p.getName(), p.getDob().toEpochDay() * 3600 * 24 * 1000);
    }
}
