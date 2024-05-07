package grp1.BarBis;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import grp1.BarBis.entities.Plat;
import grp1.BarBis.exceptions.PlatException;
import grp1.BarBis.services.PlatService;

@SpringBootTest
public class PlatTest {

    @Autowired
    private PlatService platSrv;

    @Test
	void getByIdExceptionTest() {
		assertThrows(PlatException.class, () -> {
			platSrv.getById(9999999L);
		});
	}

    @Test
	void createPlatTest() {
		assertThrows(PlatException.class, () -> {
			platSrv.create(new Plat("", "", 10.));
		});
		assertThrows(PlatException.class, () -> {
			platSrv.create(new Plat(null, null, 10.));
		});
        assertThrows(PlatException.class, () -> {
			platSrv.create(new Plat("test1", "Planche", 0.));
		});
		assertNotNull(platSrv.getById(platSrv.create(new Plat("test1", "planche", 10.)).getId()));
	}

	@Test
	void deletePlat(){
		Plat tapas1 = new Plat ("tapas1", "tapas", 5.20);
		Plat planche2 = new Plat("plat2", "Planche", 9.8);
		platSrv.create(planche2);
		platSrv.create(tapas1);
		platSrv.delete(planche2);
	}

	@Test
	void updatePlat(){
		Plat tapas1 = new Plat ("tapas1", "tapas", 5.20);
		platSrv.create(tapas1);
		tapas1.setNom("tapas1.1");
		tapas1.setCategorie("newTapas");
		tapas1.setPrix(2.5);
		platSrv.update(tapas1);
	}
}
