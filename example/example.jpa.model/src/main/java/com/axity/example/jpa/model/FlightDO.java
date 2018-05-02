package com.axity.example.jpa.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * Entidad de la tabla K_VUELO
 * 
 * @author irvin uriel
 */
@Entity
@Table(name = "K_VUELO")
@NamedQueries({
	@NamedQuery(name="FlightDO.findByDates", query="SELECT f FROM FlightDO f WHERE f.scheduleDepartureUtc BETWEEN :dateStar AND :dateEnd "),
	@NamedQuery(name="FlightDO.findByDelayArrive", query="SELECT f FROM FlightDO f WHERE f.scheduleDepartureUtc BETWEEN :dateStar AND :dateEnd ORDER BY f.delayArrive DESC"),
	@NamedQuery(name="FlightDO.findByRegistration", query="SELECT f FROM FlightDO f INNER JOIN f.idAircraft air WHERE air.registration = :registration AND ( f.scheduleDepartureUtc BETWEEN :dateStar AND :dateEnd )"),
	@NamedQuery(name="FlightDO.findByCarrier", query="SELECT f FROM FlightDO f INNER JOIN f.idAircraft air INNER JOIN air.carrier car WHERE car.code = :codeCarrier AND ( f.scheduleDepartureUtc BETWEEN :dateStar AND :dateEnd )"),
	@NamedQuery(name="FlightDO.findByFlight", query="SELECT f FROM FlightDO f WHERE f.idFlight = :idFlight AND ( f.scheduleDepartureUtc BETWEEN :dateStar AND :dateEnd )"),
	@NamedQuery(name="FlightDO.findByDelayDeparture", query="SELECT f FROM FlightDO f WHERE f.scheduleDepartureUtc BETWEEN :dateStar AND :dateEnd ORDER BY f.delayDeparture DESC")
})
public class FlightDO extends AbstractEntity<FlightDO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7751254796752496525L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VUELO")
	private Integer idFlight;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AERONAVE", referencedColumnName = "ID_AERONAVE")
	private AircraftDO idAircraft;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RUTA", referencedColumnName = "ID_RUTA")
	private RouteDO route;
	
	@Column(name = "QT_VUELO")
	private Integer flight;

	@Column(name = "DT_SCH_DEPARTURE_UTC")
	@Temporal(TemporalType.DATE)
	private Date scheduleDepartureUtc;

	@Column(name = "DT_ACT_DEPARTURE_UTC")
	@Temporal(TemporalType.DATE)
	private Date actualDepartureUtc;

	@Column(name = "DT_SCH_ARRIVE_UTC")
	@Temporal(TemporalType.DATE)
	private Date scheduleArriveUtc;

	@Column(name = "DT_ACT_ARRIVE_UTC")
	@Temporal(TemporalType.DATE)
	private Date actualArriveUtc;

	@Column(name = "QT_TIME_DELAY_DEP")
	private Integer delayDeparture;

	@Column(name = "QT_TIME_DELAY_ARR")
	private Integer delayArrive;
	/**
	 * @return the idFlight
	 */
	public Integer getIdFlight() {
		return idFlight;
	}
	/**
	 * @param idFlight
	 *            the idFlight to set
	 */
	public void setIdFlight(Integer idFlight) {
		this.idFlight = idFlight;
	}
	/**
	 * @return the idAircraft
	 */
	public AircraftDO getAircraft() {
		return idAircraft;
	}
	/**
	 * @param idFlight
	 *            the idAircraft to set
	 */
	public void setAircraft(AircraftDO aircraft) {
		this.idAircraft = aircraft;
	}
	/**
	 * @return the route
	 */
	public RouteDO getRoute() {
		return route;
	}
	/**
	 * @param idFlight
	 *            the route to set
	 */
	public void setRoute(RouteDO route) {
		this.route = route;
	}
	/**
	 * @return the flight
	 */
	public Integer getFlight() {
		return flight;
	}
	/**
	 * @param idFlight
	 *            the flight to set
	 */
	public void setFlight(Integer flight) {
		this.flight = flight;
	}
	/**
	 * @return the scheduleDepartureUtc
	 */
	public Date getScheduleDepartureUtc() {
		return scheduleDepartureUtc;
	}
	/**
	 * @param idFlight
	 *            the scheduleDepartureUtc to set
	 */
	public void setScheduleDepartureUtc(Date scheduleDepartureUtc) {
		this.scheduleDepartureUtc = scheduleDepartureUtc;
	}
	/**
	 * @return the actualDepartureUtc
	 */
	public Date getActualDepartureUtc() {
		return actualDepartureUtc;
	}
	/**
	 * @param idFlight
	 *            the actualDepartureUtc to set
	 */
	public void setActualDepartureUtc(Date actualDepartureUtc) {
		this.actualDepartureUtc = actualDepartureUtc;
	}
	/**
	 * @return the scheduleArriveUtc
	 */
	public Date getScheduleArriveUtc() {
		return scheduleArriveUtc;
	}
	/**
	 * @param idFlight
	 *            the scheduleArriveUtc to set
	 */
	public void setScheduleArriveUtc(Date scheduleArriveUtc) {
		this.scheduleArriveUtc = scheduleArriveUtc;
	}
	/**
	 * @return the actualArriveUtc
	 */
	public Date getActualArriveUtc() {
		return actualArriveUtc;
	}
	/**
	 * @param idFlight
	 *            the actualArriveUtc to set
	 */
	public void setActualArriveUtc(Date actualArriveUtc) {
		this.actualArriveUtc = actualArriveUtc;
	}
	/**
	 * @return the delayDeparture
	 */
	public Integer getDelayDeparture() {
		return delayDeparture;
	}
	/**
	 * @param idFlight
	 *            the delayDeparture to set
	 */
	public void setDelayDeparture(Integer delayDeparture) {
		this.delayDeparture = delayDeparture;
	}
	/**
	 * @return the delayArrive
	 */
	public Integer getDelayArrive() {
		return delayArrive;
	}
	/**
	 * @param idFlight
	 *            the delayArrive to set
	 */
	public void setDelayArrive(Integer delayArrive) {
		this.delayArrive = delayArrive;
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
		FlightDO other = (FlightDO) obj;
		if (idFlight == null) {
			if (other.idFlight != null)
				return false;
		} else if (!idFlight.equals(other.idFlight))
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
		result = prime * result + ((idFlight == null) ? 0 : idFlight.hashCode());
		return result;
	}
	/**
	 * @return
	 */
	@Override
    public String toString() {
		return new ToStringBuilder( this ).append( "idFlight", this.idFlight ).append( "idAircraft", this.idAircraft )
				.append( "flight", this.flight ).toString();
    }

}
