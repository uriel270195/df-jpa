package com.axity.example.jpa.persistence.dao.impl;

import java.awt.Window.Type;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import com.axity.example.jpa.model.AircraftDO;
import com.axity.example.jpa.model.CarrierDO;
import com.axity.example.jpa.persistence.base.GenericBaseDAOImpl;
import com.axity.example.jpa.persistence.dao.AircraftDAO;

public class AircraftDAOImpl extends GenericBaseDAOImpl<AircraftDO> implements AircraftDAO{
	
	public AircraftDAOImpl() {
		super(AircraftDO.class);
	}

	@Override
	public List<AircraftDO> findByCarrierId(Integer idCarrier) {
		TypedQuery<AircraftDO> namedQuery = super.getEntityManager().createNamedQuery("AircraftDO.findByCarrierId",
				AircraftDO.class);
		namedQuery.setParameter("idCarrier", idCarrier);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<AircraftDO> findByRegistration(String registration) {
		TypedQuery<AircraftDO> namedQuery = super.getEntityManager().createNamedQuery("AircraftDO.findByRegistration",
				AircraftDO.class);
		namedQuery.setParameter("registration", registration);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<AircraftDO> findByCarrierCode(String code) {
		TypedQuery<AircraftDO> namedQuery = super.getEntityManager().createNamedQuery("AircraftDO.findByCarrierCode",
				AircraftDO.class);
		namedQuery.setParameter("code",code);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<AircraftDO> findByAircraftId(Integer idAircraft) {
		TypedQuery<AircraftDO> namedQuery = super.getEntityManager().createNamedQuery("AircraftDO.findByAircraftId",
				AircraftDO.class);
		namedQuery.setParameter("idAircraft", idAircraft);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<AircraftDO> findByAircraftCode(String idAircraftType) {
		TypedQuery<AircraftDO> namedQuery = super.getEntityManager().createNamedQuery("AircraftDO.findByAircraftCode",
				AircraftDO.class);
		namedQuery.setParameter("idAircraftType",idAircraftType);
		return findByNamedQuery(namedQuery);
	}

	@Override
	public List<AircraftDO> findByRouteCode(String codeRoute,Date dateStart, Date dateEnd) {
		TypedQuery<AircraftDO> namedQuery = super.getEntityManager().createNamedQuery("AircraftDO.findByRouteCode",AircraftDO.class);
		namedQuery.setParameter("codeRoute",codeRoute);
		namedQuery.setParameter("dateStart",dateStart);
		namedQuery.setParameter("dateEnd",dateEnd);		
		return findByNamedQuery(namedQuery);
	}
	
}
