package com.cg.cabbookingsystem.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.repo.DriverRepo;
import com.cg.cabbookingsystem.repo.DriverRepoImpl;
import com.cg.cabbookingsystem.service.DriverService;
import com.cg.cabbookingsystem.service.DriverServiceImpl;

public class DriverControllerTest {
	static Vehicle vehicle1;
	static Vehicle vehicle2;
	static DriverRepo repo;
	static EntityManager mgr;
	static List<Vehicle> vehicles;
	
	@BeforeClass
	public static void setup() {
		//mgr =Persistence.createEntityManagerFactory("MyJPA").createEntityManager();
		repo = new DriverRepoImpl(mgr);
		vehicle1 = Mockito.mock(Vehicle.class);
		vehicle2 = Mockito.mock(Vehicle.class);
		vehicle1.setVehicleNo("MH123");
		vehicle2.setVehicleNo("MH321");
		vehicle1.setStatus("free");
		vehicle2.setStatus("booked");
		vehicles = new ArrayList<Vehicle>();
	}
	@Test
	public void testGetASuitableDriver() {
		Driver driver1 = new Driver();
		Driver driver2 = new Driver();
		driver1.setVehicleNo("MH123");
		driver2.setVehicleNo("MH321");
		vehicles.add(vehicle1);
		vehicles.add(vehicle2);
		//service.getListOfDrivers(vehicles);
		assertNull(repo.getOneDriver(vehicles));
	}

	@Test
	public void testSearchForBooking() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHistoryOfDriver() {
		fail("Not yet implemented");
	}

	@Test
	public void testFetchDriver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBookingForADriver() {
		fail("Not yet implemented");
	}

}
