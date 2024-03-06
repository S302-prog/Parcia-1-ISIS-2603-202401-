package co.edu.uniandes.dse.parcial1.entities;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.List;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Data
@Entity
public class TallerEntity extends BaseEntity{
    private String nombre;
    
    @Temporal(TemporalType.DATE)
	@PodamStrategyValue(co.edu.uniandes.dse.parcial1.podam.DateStrategy.class)
	private Date fundacionFecha;

    private String slogan;

    @PodamExclude
    @ManyToMany
    private List<MarcaEntity> marcasAsociadas =  new ArrayList<>();
}
