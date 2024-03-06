package co.edu.uniandes.dse.parcial1.services;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.TallerEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.TallerRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TallerService {

    @Autowired
    TallerRepository tallerRepository;

    @Transactional
    public TallerEntity createTaller(TallerEntity taller) throws IllegalOperationException{
        log.info("Inicia proceso de creación un taller");
        Calendar calendar = Calendar.getInstance();
		if(taller.getFundacionFecha().compareTo(calendar.getTime()) > 0) {
			throw new IllegalOperationException("La fecha de fundacion es despues de la actual");
	    }
        String slogan = taller.getSlogan();
        if(slogan.length() > 50){
            throw new IllegalOperationException("El slogan no puede tener mas de 50 caracteres");
        }
        return tallerRepository.save(taller);
    }
}
