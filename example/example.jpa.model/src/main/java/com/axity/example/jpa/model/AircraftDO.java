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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * Entidad de la tabla K_AERONAVE
 * 
 * @author irvin uriel
 */
@Entity
@Table(name = "K_AERONAVE")

@NamedQueries({ 
	@NamedQuery(name = "AircraftDO.findByCarrierId", query = " SELECT a FROM AircraftDO a INNER JOIN a.carrier c WHERE c.idCarrier = :idCarrier"),
	@NamedQuery(name = "AircraftDO.findByRegistration", query = " SELECT r FROM AircraftDO r WHERE r.registration LIKE :registration "),
	@NamedQuery(name = "AircraftDO.findByCarrierCode", query = " SELECT a FROM AircraftDO a INNER JOIN a.carrier c WHERE c.code = :code"),
	@NamedQuery(name = "AircraftDO.findByAircraftId", query = " SELECT a FROM AircraftDO a WHERE a.idAircraft = :idAircraft"),
	@NamedQuery(name = "AircraftDO.findByAircraftCode", query = " SELECT a FROM AircraftDO a INNER JOIN a.aircraftType ar WHERE ar.code = :idAircraftType"),
	@NamedQuery(name = "AircraftDO.findByRouteCode", query = " SELECT a FROM AircraftDO a INNER JOIN a.flights f INNER JOIN f.route r WHERE r.code = :codeRoute AND (f.scheduleDepartureUtc BETWEEN :dateStart AND :dateEnd)")})
public class AircraftDO extends AbstractEntity<AircraftDO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8691314170044845794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AERONAVE")
	private Integer idAircraft;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_AERONAVE", referencedColumnName = "ID_TIPO_AERONAVE")
	private AircraftTypeDO aircraftType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AEROLINEA", referencedColumnName = "ID_AEROLINEA")
	private CarrierDO carrier;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="idAircraft")
	private List<FlightDO>flights;
	
	@Column(name = "DS_MATRICULA", length = 10)
	private String registration;
	/**
	 * @return the IdAircraft
	 */
	public Integer getIdAircraft() {
		return idAircraft;
	}
	/**
	 * @param IdAircraft
	 *            the IdAircraft to set
	 */
	public void setIdAircraft(Integer idAircraft) {
		this.idAircraft = idAircraft;
	}
	/**
	 * @return the AircraftType
	 */
	public AircraftTypeDO getAircraftType() {
		return aircraftType;
	}
	/**
	 * @param IdAircraft
	 *            the AircraftType to set
	 */
	public void setAircraftType(AircraftTypeDO aircraftType) {
		this.aircraftType = aircraftType;
	}
	/**
	 * @return the carrier
	 */
	public CarrierDO getCarrier() {
		return carrier;
	}
	/**
	 * @param IdAircraft
	 *            the carrier to set
	 */
	public void setCarrier(CarrierDO carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the registration
	 */
	public String getMatricula() {
		return registration;
	}
	/**
	 * @param IdAircraft
	 *            the registration to set
	 */
	public void setMatricula(String matricula) {
		this.registration = matricula;
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
		AircraftDO other = (AircraftDO) obj;
		if (idAircraft == null) {
			if (other.idAircraft != null)
				return false;
		} else if (!idAircraft.equals(other.idAircraft))
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
		result = prime * result + ((idAircraft == null) ? 0 : idAircraft.hashCode());
		return result;
	}
	/**
	 * @return
	 */
	@Override
    public String toString() {
		return new ToStringBuilder( this ).append( "idAircraft", this.idAircraft ).append( "registration", this.registration ).toString();
    }

	

}
