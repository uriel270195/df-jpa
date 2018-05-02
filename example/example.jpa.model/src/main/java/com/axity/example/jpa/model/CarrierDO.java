package com.axity.example.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Entidad de la tabla C_AEROLINEA
 * 
 * @author gsegura
 */
@Entity
@Table(name = "C_AEROLINEA")
@NamedQueries({ @NamedQuery(name = "CarrierDO.findByCode", query = "SELECT o FROM CarrierDO o WHERE o.code = :code"),
		@NamedQuery(name = "CarrierDO.findByName", query = "SELECT o FROM CarrierDO o WHERE o.name LIKE :name") })
public class CarrierDO extends AbstractCatalogEntity<CarrierDO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2300320077270334506L;
	@Id
	@Column(name = "ID_AEROLINEA")
	private Integer idCarrier;

	@OneToMany(mappedBy = "carrier")
	private List<AircraftDO> aircrafts;

	public List<AircraftDO> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<AircraftDO> aircrafts) {
		this.aircrafts = aircrafts;
	}

	/**
	 * @return the idCarrier
	 */
	public Integer getIdCarrier() {
		return idCarrier;
	}

	/**
	 * @param idCarrier
	 *            the idCarrier to set
	 */
	public void setIdCarrier(Integer idCarrier) {
		this.idCarrier = idCarrier;
	}

	/**
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		boolean isEquals = false;
		if (this == object) {
			isEquals = true;
		} else if (object != null && object.getClass().equals(this.getClass())) {
			CarrierDO that = (CarrierDO) object;
			isEquals = new EqualsBuilder().append(this.idCarrier, that.idCarrier).isEquals();
		}
		return isEquals;
	}

	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.idCarrier).toHashCode();
	}
	/**
	 * @return
	 */
	@Override
	public String toString()
	{
		return new ToStringBuilder( this ).append( "idAirline", this.idCarrier ).append( "name", this.name )
				.append( "code", this.code ).toString();
	}

}
