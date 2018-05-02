package com.axity.example.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.axity.example.jpa.model.CountryDO;
/**
 * Entidad de la tabla C_ESTACION
 * 
 * @author irvin uriel
 */
@Entity
@Table(name="C_ESTACION")
public class StationDO extends AbstractCatalogEntity<StationDO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3460285335891735722L;

	@Id
	@Column(name = "ID_ESTACION")
	private Integer idStation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PAIS",referencedColumnName="ID_PAIS") 
	private CountryDO country ;
	
	@OneToMany(mappedBy="departure")
	private List<RouteDO> departureRoutes;
	
	@OneToMany(mappedBy="arrive")
	private List<RouteDO> arriveRoutes;

	/**
	 * @return the idStation
	 */
	public Integer getIdStation() {
		return idStation;
	}
	/**
	 * @param idStation
	 *            the idStation to set
	 */
	public void setIdStation(Integer idStation) {
		this.idStation = idStation;
	}
	/**
	 * @return the country
	 */
	public CountryDO getCountry() {
		return country;
	}
	/**
	 * @param idStation
	 *            the country to set
	 */

	public void setCountry(CountryDO country) {
		this.country = country;
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
		StationDO other = (StationDO) obj;
		if (idStation == null) {
			if (other.idStation != null)
				return false;
		} else if (!idStation.equals(other.idStation))
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
		result = prime * result + ((idStation == null) ? 0 : idStation.hashCode());
		return result;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return new ToStringBuilder( this ).append( "idStation", this.idStation ).append( "country", this.country )
				.append( "departureRoutes", this.departureRoutes ).append( "arriveRoutes", this.arriveRoutes ).toString();
	}
	
	
	
}
