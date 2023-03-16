package at.htl.vehicle.person;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Table(name="person")
@Entity
public class Person {
    @Id
    @SequenceGenerator(initialValue = 1, name="person_sequence", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    @Column(name="id")
    private Long id;

    @NonNull
    @Column(name="name")
    private String name;

    @NonNull
    @Column(name="dbob")
    private LocalDate dob;

    public Person() {
    }
}
