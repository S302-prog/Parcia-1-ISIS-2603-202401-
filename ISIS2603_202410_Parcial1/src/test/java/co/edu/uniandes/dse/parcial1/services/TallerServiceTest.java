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
import co.edu.uniandes.dse.parcial1.entities.TallerEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import lombok.Data;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(TallerService.class)
public class TallerServiceTest {
    @Autowired
    private TallerService tallerService;

    @Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<TallerEntity> marcaList = new ArrayList<>();

    @Test
    void testCreateTaller() throws IllegalOperationException{
        TallerEntity newEntity = factory.manufacturePojo(TallerEntity.class);

        TallerEntity result = tallerService.createTaller(newEntity);
		assertNotNull(result);

        TallerEntity entity = entityManager.find(TallerEntity.class, result.getId());

        assertEquals(newEntity.getFundacionFecha(), entity.getFundacionFecha());
		assertEquals(newEntity.getNombre(), entity.getNombre());
		assertEquals(newEntity.getSlogan(), entity.getSlogan());
	}

    @Test
    void testCreateTallerInvalid() throws IllegalOperationException{
        TallerEntity newEntity = factory.manufacturePojo(TallerEntity.class);

        TallerEntity result = tallerService.createTaller(newEntity);
		assertNotNull(result);

        TallerEntity entity = entityManager.find(TallerEntity.class, result.getId());

        newEntity.setNombre("qwerasdfzxcvwerqwerqwerqwerqwerqwerwqeqwerwqerrqwerqwerwqerqwerqwerqwerqwerwqerqwer");

        assertEquals(newEntity.getFundacionFecha(), entity.getFundacionFecha());
		assertEquals(newEntity.getSlogan(), entity.getSlogan());
	}


}