package com.axity.example.jpa.persistence.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.axity.example.jpa.model.AircraftDO;
import com.axity.example.jpa.model.FlightDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/initial-test-context.xml" })
@Transactional
public class AircraftDAOTest {
	@Autowired
	private AircraftDAO aircraftDAO;
	
	@Test
	public void testFindByCarrierId() {
		Integer idCarrier = 2;
		List <AircraftDO> result = aircraftDAO.findByCarrierId(idCarrier);
		Assert.assertNotNull( result );
		imp(result);
	}
	
	@Test
	public void testFindByRegistration() {
		String registration = "N723AV";
		List <AircraftDO> result = aircraftDAO.findByRegistration(registration);
		Assert.assertNotNull( result );
		imp(result);
	}
	
	
	@Test
	public void testFindByCarrierCode() {
		String code = "AV";
		List <AircraftDO> result = aircraftDAO.findByCarrierCode(code);
		Assert.assertNotNull( result );
		imp(result);
	}
	
	@Test
	public void testFindByAircraftId() {
		Integer idAircraft = 1;
		List <AircraftDO> result = aircraftDAO.findByAircraftId(idAircraft);
		imp(result);
	}
	
	@Test
	public void testFindByAircraftCode() {
		String idAircraft = "763";
		List <AircraftDO> result = aircraftDAO.findByAircraftCode(idAircraft);
		imp(result);
	}
			
	/*@Test
	public void testFindByRouteCode(){
	}*/
	public void imp(List<AircraftDO> r) {
		for(AircraftDO i:r) {
			System.out.println(i);
		}
	}
}
