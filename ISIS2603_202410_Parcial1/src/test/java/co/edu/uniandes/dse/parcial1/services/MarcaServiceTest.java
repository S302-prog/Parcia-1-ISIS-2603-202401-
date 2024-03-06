package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcial1.entities.MarcaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import lombok.Data;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(MarcaService.class)
public class MarcaServiceTest {
    @Autowired
    private MarcaService marcaService;

    @Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<MarcaEntity> marcaList = new ArrayList<>();

    @Test
    void testCreateMarca() throws IllegalOperationException{
        MarcaEntity newEntity = factory.manufacturePojo(MarcaEntity.class);

        MarcaEntity result = marcaService.createMarca(newEntity);
		assertNotNull(result);

        MarcaEntity entity = entityManager.find(MarcaEntity.class, result.getId());

        assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getNombre(), entity.getNombre());
		assertEquals(newEntity.getLogo(), entity.getLogo());
		assertEquals(newEntity.getResena(), entity.getResena());
	}

    @Test
    void testCreateMarcaInvalid() throws IllegalOperationException{
        MarcaEntity newEntity = factory.manufacturePojo(MarcaEntity.class);

        MarcaEntity result = marcaService.createMarca(newEntity);
		assertNotNull(result);

        MarcaEntity entity = entityManager.find(MarcaEntity.class, result.getId());

        newEntity.setLogo(null);

        assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getNombre(), entity.getNombre());
		assertEquals(newEntity.getResena(), entity.getResena());
	}


}


