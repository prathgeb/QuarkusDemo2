package at.htl.vehicle.person;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void itShoudHaveNameSusi_givenNameSusi() {
        var p = new Person("Peter Rathgeb", LocalDate.of(1987, 12, 26));
        assertThat(p.getName()).isEqualTo("Peter Rathgeb");
    }

}