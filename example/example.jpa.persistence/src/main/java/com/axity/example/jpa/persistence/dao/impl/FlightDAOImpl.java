package com.axity.example.jpa.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import com.axity.example.jpa.model.FlightDO;
import com.axity.example.jpa.persistence.base.GenericBaseDAOImpl;
import com.axity.example.jpa.persistence.dao.FlightDAO;

public class FlightDAOImpl extends GenericBaseDAOImpl<FlightDO> implements FlightDAO {

	public FlightDAOImpl() {
		super(FlightDO.class);
	}
	
	@Override
	public List<FlightDO> findByDates(Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByDates",
				FlightDO.class);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<FlightDO> findByRouteCode(String codeRoute, Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByRouteCode",
				FlightDO.class);
		namedQuery.setParameter("codeRoute", codeRoute);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<FlightDO> findByStationDepartureCode(String codeStation, Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByStationDepartureCode",
				FlightDO.class);
		namedQuery.setParameter("codeStation", codeStation);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<FlightDO> findByCarrier(String codeCarrier, Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByCarrier",
				FlightDO.class);
		namedQuery.setParameter("codeCarrier", codeCarrier);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<FlightDO> findByRegistration(String registration, Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByRegistration",
				FlightDO.class);
		namedQuery.setParameter("registration", registration);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<FlightDO> findByFlight(Integer idFlight, Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByFlight",
				FlightDO.class);
		namedQuery.setParameter("idFlight", idFlight);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<FlightDO> findByDelayDeparture(Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByDelayDeparture",
				FlightDO.class);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<FlightDO> findByDelayArrive(Date dateStart, Date dateEnd) {
		TypedQuery<FlightDO> namedQuery = super.getEntityManager().createNamedQuery("FlightDO.findByDelayArrive",
				FlightDO.class);
		namedQuery.setParameter("dateStar", dateStart);
		namedQuery.setParameter("dateEnd", dateEnd);
		return findByNamedQuery(namedQuery);
	}
	
	

}

