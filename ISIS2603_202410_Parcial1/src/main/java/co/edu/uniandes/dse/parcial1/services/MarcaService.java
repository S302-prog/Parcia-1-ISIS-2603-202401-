package co.edu.uniandes.dse.parcial1.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.MarcaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.MarcaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MarcaService {
        
    @Autowired
    MarcaRepository marcaRepository;

    @Transactional
    public MarcaEntity createMarca(MarcaEntity marca) throws IllegalOperationException{
        String logo = marca.getLogo();
        if(logo.contains("https//")){
            throw new IllegalOperationException("El logo no contiene https/");
        }
        return marcaRepository.save(marca);
    }
}
