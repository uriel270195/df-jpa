package com.axity.example.jpa.persistence.dao;

import java.util.Date;
import java.util.List;

import com.axity.example.jpa.model.AircraftDO;
import com.axity.example.jpa.persistence.base.GenericDAO;

/**
 * DAO de la tabla K_AERONAVE
 * 
 * @author irvin uriel
 */
public interface AircraftDAO extends GenericDAO<AircraftDO>
{

  /**
   * Busca las aeronaves por el codigo del tipo de aeronave
   * 
   * @param code
   * @return
   */
  List<AircraftDO> findByAircraftCode(String code);

  /**
   * Busca las aeronaves por el id del tipo de aeronave
   * 
   * @param name
   * @return
   */
  List<AircraftDO> findByAircraftId(Integer idAircraft);
  /**
   * Busca las aeronaves por el código de la línea aerea
   * 
   * @param code
   * @return
   */
  List<AircraftDO> findByCarrierCode(String code);

  /**
   * Busca las aeronaves por el id de la línea aerea
   * 
   * @param name
   * @return
   */
  List<AircraftDO> findByCarrierId(Integer idCarrier);
  /**
   * Busca las aeronaves por su numero de registro (matrícula)
   * 
   * @param code
   * @return
   */
  List<AircraftDO> findByRegistration(String registration);

  /**
   * Busca las aeronaves que cubre una ruta en un rango de fechas
   * 
   * @param name
   * @return
   */
  List<AircraftDO> findByRouteCode(String code, Date start, Date end);
}
