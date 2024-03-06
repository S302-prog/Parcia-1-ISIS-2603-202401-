package co.edu.uniandes.dse.parcial1.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.uniandes.dse.parcial1.entities.MarcaEntity;
import co.edu.uniandes.dse.parcial1.entities.TallerEntity;
import co.edu.uniandes.dse.parcial1.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.MarcaRepository;
import co.edu.uniandes.dse.parcial1.repositories.TallerRepository;

public class TallerMarcaService {
    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    TallerRepository tallerRepository;

    @Transactional
    public MarcaEntity addMarca(Long idMarca, Long idTaller) throws EntityNotFoundException, IllegalOperationException {

        java.util.Optional<MarcaEntity> marcaEntity = marcaRepository.findById(idMarca);
        if(marcaEntity.isEmpty())
			throw new EntityNotFoundException("La marca que desea agregar no existe");

        java.util.Optional<TallerEntity> tallerEntity = tallerRepository.findById(idTaller);
        if(tallerEntity.isEmpty())
                throw new EntityNotFoundException("El taller que desea buscar no existe");

        tallerEntity.get().getMarcasAsociadas().add(marcaEntity.get());
        return marcaEntity.get();
    }
}
