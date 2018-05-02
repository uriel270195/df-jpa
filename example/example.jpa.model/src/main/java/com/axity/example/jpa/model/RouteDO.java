package com.axity.example.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * Entidad de la tabla K_RUTA
 * 
 * @author irvin uriel
 */
@Entity
@Table(name="K_RUTA")
public class RouteDO extends AbstractEntity<RouteDO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3464065186569841067L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RUTA")
	private Integer idRute;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ESTACION_DEP",referencedColumnName="ID_ESTACION")
	private StationDO departure;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ESTACION_ARR",referencedColumnName="ID_ESTACION")
	private StationDO arrive;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="route")
	private List<FlightDO>flights;
	
	@Column(name = "DS_CODE",length=6)
	private Integer code;
	/**
	 * @return the idRute
	 */
	public Integer getIdRute() {
		return idRute;
	}
	/**
	 * @param idRute
	 *            the idRute to set
	 */
	public void setIdRute(Integer idRute) {
		this.idRute = idRute;
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param idRute
	 *            the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RouteDO other = (RouteDO) obj;
		if (idRute == null) {
			if (other.idRute != null)
				return false;
		} else if (!idRute.equals(other.idRute))
			return false;
		return true;
	}
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRute == null) ? 0 : idRute.hashCode());
		return result;
	}
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return new ToStringBuilder( this ).append( "idRute", this.idRute ).append( "departure", this.departure )
				.append( "arrive", this.arrive ).append( "flights", this.flights ).append( "code", this.code ).toString();
	}

}
