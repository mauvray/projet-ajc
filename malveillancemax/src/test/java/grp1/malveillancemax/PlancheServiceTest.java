package grp1.malveillancemax;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

// import jakarta.transaction.Transactional;

// import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.annotation.Rollback;

import grp1.malveillancemax.exceptions.PlancheException;
import grp1.malveillancemax.services.PlancheService;
import grp1.malveillancemax.entities.Planche;

@SpringBootTest
// @Transactional
// @Rollback
public class PlancheServiceTest {

	@Autowired
	private PlancheService plancheSrv;

	@Test
	void getByIdExceptionTest() {
		assertThrows(PlancheException.class, () -> {
			plancheSrv.getById(9999999L);
		});
	}

	@Test
	// @Commit
	void createPlancheTest() {
		assertThrows(PlancheException.class, () -> {
			plancheSrv.create(new Planche("", 10.));
		});
		assertThrows(PlancheException.class, () -> {
			plancheSrv.create(new Planche(null, 10.));
		});
        assertThrows(PlancheException.class, () -> {
			plancheSrv.create(new Planche("test1", 0.));
		});
		assertNotNull(plancheSrv.getById(plancheSrv.create(new Planche("test1", 10.)).getId()));
	}

}