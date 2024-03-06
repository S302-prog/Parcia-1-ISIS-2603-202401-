package co.edu.uniandes.dse.parcial1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class MarcaEntity extends BaseEntity{

    private String nombre;
    private String logo;
    private String resena;

    @PodamExclude
    @ManyToMany
    private List<TallerEntity> talleresAsociados =  new ArrayList<>();
}
