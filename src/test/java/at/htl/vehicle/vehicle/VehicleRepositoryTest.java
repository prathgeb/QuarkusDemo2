package at.htl.vehicle.vehicle;

import io.agroal.api.AgroalDataSource;
import io.quarkus.narayana.jta.QuarkusTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

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
        QuarkusTransaction.begin();
        var vehicle = new Vehicle("Kadett", "Opel");
        repo.persist(vehicle);
        QuarkusTransaction.commit();

        Table table = new Table(ds, "vehicle");
        output(table).toConsole();

        assertThat(table).exists().hasNumberOfRows(1);
    }

}