package at.htl.vehicle.rental;

import at.htl.vehicle.person.Person;
import at.htl.vehicle.vehicle.Vehicle;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="rental")
public class Rental {

    @NonNull
    @Id
    @SequenceGenerator(initialValue = 1, name="rental_sequence", sequenceName = "rental_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_sequence")
    @Column(name="id")
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable = false)
    private Vehicle vehicle;

    @NonNull
    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private Person person;

    @NonNull
    @Column(name="start_date")
    private LocalDateTime startDateTime;

    @NonNull
    @Column(name="end_date")
    private LocalDateTime endDateTime;

    @NonNull
    @Column(name="discount")
    private BigDecimal discount;

    public Rental() {

    }

}
