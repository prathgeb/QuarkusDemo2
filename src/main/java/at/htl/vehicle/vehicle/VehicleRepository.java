package at.htl.vehicle.vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;


@ApplicationScoped
public class VehicleRepository {
    @Inject
    EntityManager em;

    public Vehicle find(Long id) {
        return em.find(Vehicle.class, id);
    }

    public Vehicle find2(Long id) {
        return em.createQuery(
                "select v FROM Vehicle v WHERE v.id = :ID", Vehicle.class
                )
                .setParameter("ID", id)
                .getSingleResult();
    }

    public List<Vehicle> findAll() {
        return em.createNamedQuery("Vehicle.findAll", Vehicle.class).getResultList();
    }

    public List<Vehicle> findAll2() {
        return em.createQuery("SELECT v from Vehicle v", Vehicle.class).getResultList();
    }

    public Vehicle create(Vehicle vehicle) {
        if (Objects.nonNull(vehicle.getId())) {
            throw new IllegalStateException("Id should be null!");
        }
        em.persist(vehicle);
        return vehicle;
    }

    public void persist(Vehicle vehicle) {
        //em.persist(vehicle);
    }
}
