package at.htl.vehicle.vehicle;

import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleRepositoryTest {

    @Inject
    VehicleRepository repo;

    @Inject
    AgroalDataSource ds;

    @Test
    void name() {
        var vehicle = new Vehicle("Kadett", "Opel");
        repo.persist(vehicle);

        Table table = new Table(ds, "vehicle");
        output(table).toConsole();

        assertThat(table).exists().hasNumberOfRows(1);
    }

}