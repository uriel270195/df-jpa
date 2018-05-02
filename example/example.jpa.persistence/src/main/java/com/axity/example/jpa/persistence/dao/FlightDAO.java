package com.axity.example.jpa.persistence.dao;

import java.util.Date;
import java.util.List;

import com.axity.example.jpa.model.FlightDO;
import com.axity.example.jpa.persistence.base.GenericDAO;

/**
 * DAO de la tabla K_VUELO
 * 
 * @author irvin uriel
 */
public interface FlightDAO extends GenericDAO<FlightDO>
{

  /**
   * Busca los vuelos en un rango de tiempo, por el codigo de la aerolinea
   * 
   * @param code
   * @return
   */
  List<FlightDO> findByCarrier( String carrierCode, Date start, Date end );

  /**
   * Busca los vuelos en un rango de tiempo
   * 
   * @param name
   * @return
   */
  List<FlightDO> findByDates( Date start, Date end );
  
  /**
   * Busca los vuelos con demora en llegada, mayor a cero, en un rango de tiempo
   * 
   * @param code
   * @return
   */
  List<FlightDO> findByDelayArrive( Date start, Date end );

  /**
   * Busca los vuelos con demora en salida, mayor a cero, en un rango de tiempo
   * 
   * @param name
   * @return
   */
  List<FlightDO> findByDelayDeparture( Date start, Date end );
  
  /**
   * Busca los vuelos en un rango de tiempo por el numero de vuelo
   * 
   * @param code
   * @return
   */
  List<FlightDO> findByFlight( Integer flight, Date start, Date end );

  /**
   * Busca los vuelos en un rango de tiempo por la matricula del avion
   * 
   * @param name
   * @return
   */
  List<FlightDO> findByRegistration( String registration, Date start, Date end );
  
  /**
   * Busca las rutas en un rango de tiempo, por código de ruta i.e.
   * 
   * @param code
   * @return
   */
  List<FlightDO> findByRouteCode(String code, Date start, Date end );

  /**
   * Busca los vuelos en un rango de tiempo, por el codigo de la estacion de salida
   * 
   * @param name
   * @return
   */
  List<FlightDO> findByStationDepartureCode(String departureStationCode, Date start, Date end);
}
