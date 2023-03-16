package at.htl.vehicle.vehicle;

import lombok.*;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "vehicle")
@NamedQuery(name="Vehicle.findAll", query = "SELECT v FROM Vehicle v")
public class Vehicle {
    @Id
    @SequenceGenerator(initialValue = 1, name="vehicle_sequence", sequenceName = "vehicle_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_sequence")
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "model", nullable = false)
    private String model;

    @NonNull
    @Column(name = "brand", nullable = false)
    private String brand;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return String.format("%s %s", brand, model);
    }
}
