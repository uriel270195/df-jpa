package com.axity.example.jpa.persistence.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.axity.example.jpa.model.FlightDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/initial-test-context.xml" })
@Transactional
public class FlightDAOTest {

	@Autowired
	private FlightDAO flightDAO;
	private Calendar calend,calend2;
	private Date start, end;
	
	@Test
	public void testFindByDates() {
		calendario();
		List<FlightDO> result = flightDAO.findByDates(start, end);
		Assert.assertNotNull(result);
		imp(result);
	}
	
	@Test
	public void testFindByCarrier() {
		calendario();
		String codeCarrier="TA";
		List<FlightDO> result = flightDAO.findByCarrier(codeCarrier,start,end);
		Assert.assertNotNull(result);
		imp(result);
	}

	@Test
	public void testFindByRegistration() {
		calendario();
		String registration="N741AV";
		List<FlightDO> result = flightDAO.findByRegistration(registration,start,end);
		Assert.assertNotNull(result);
		imp(result);
	}
	
	@Test
	public void testFindByFlight() {
		calendario();
		Integer idFlight=31787678;
		List<FlightDO> result = flightDAO.findByFlight(idFlight,start,end);
		Assert.assertNotNull(result);
		imp(result);
	}
	
	@Test
	public void testFindByDelayDeparture() {
		calendario();
		List<FlightDO> result = flightDAO.findByDelayDeparture(start,end);
		Assert.assertNotNull(result);
		imp(result);
	}
	
	@Test
	public void testFindByDelayArrive() {
		calendario();
		List<FlightDO> result = flightDAO.findByDelayArrive(start,end);
		Assert.assertNotNull(result);
		imp(result);
	}
	/*@Test
	public void testFindByRouteCode() {
		}
	}*/
	
	/*@Test
	public void testFindByStationDepartureCode() {
	}*/
	public void calendario() {
		calend = Calendar.getInstance();
		calend.set(2018,Calendar.APRIL,1,0,0,0);
		calend.set(Calendar.MILLISECOND,0);
		start = calend.getTime();
		calend2 = Calendar.getInstance();
		calend2.set(2018,Calendar.APRIL,1,23,59,59);
		calend2.set(Calendar.MILLISECOND,999);
		end = calend2.getTime();
	}
	public void imp(List<FlightDO> r) {
		for(FlightDO i:r) {
			System.out.println(i);
		}
	}
}
