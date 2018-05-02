package com.axity.example.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * Entidad de la tabla C_TIPO_AERONAVE
 * 
 * @author irvin uriel
 */
@Entity
@Table(name = "C_TIPO_AERONAVE")
public class AircraftTypeDO extends AbstractCatalogEntity<AircraftTypeDO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1827832706083188401L;

	@Id
	@Column(name = "ID_TIPO_AERONAVE")
	private Integer idAircraftType;

	@OneToMany(mappedBy = "aircraftType")
	private List<AircraftDO> aircrafts;
	/**
	 * @return the idAircraftType
	 */
	public Integer getIdAircraftType() {
		return idAircraftType;
	}
	/**
	 * @param idAircraftType
	 *            the idAircraftType to set
	 */
	public void setIdAircraftType(Integer idAircraftType) {
		this.idAircraftType = idAircraftType;
	}
	/**
	 * @return the aircrafts
	 */
	public List<AircraftDO> getAircrafts() {
		return aircrafts;
	}
	/**
	 * @param idAircraftType
	 *            the aircrafts to set
	 */
	public void setAircrafts(List<AircraftDO> aircrafts) {
		this.aircrafts = aircrafts;
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
		AircraftTypeDO other = (AircraftTypeDO) obj;
		if (idAircraftType == null) {
			if (other.idAircraftType != null)
				return false;
		} else if (!idAircraftType.equals(other.idAircraftType))
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
		result = prime * result + ((idAircraftType == null) ? 0 : idAircraftType.hashCode());
		return result;
	}

	/**
	 * @return
	 */

	@Override
	public String toString() {
		return new ToStringBuilder( this ).append( "idAircraftType", this.idAircraftType ).append( "idAircraftType", this.idAircraftType )
				.append( "aircrafts", this.aircrafts ).toString();
	}
}
