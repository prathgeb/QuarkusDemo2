package at.htl.vehicle.rental;

import at.htl.vehicle.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;


@ApplicationScoped
public class RentalRepository {
    @Inject
    EntityManager em;

    public List<Rental> findAll() {
        return em.createQuery("SELECT r FROM Rental r", Rental.class).getResultList();
    }
}
