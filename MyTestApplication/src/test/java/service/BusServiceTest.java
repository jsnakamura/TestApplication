package service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Bus;

class BusServiceTest {

	BusService busService;
	List<Bus> busses;

	@BeforeEach
	void init() {
		busService = new BusServiceImp();
		busses = new ArrayList<Bus>();

		busses.add(new Bus(111, 654, "Joao"));
		busses.add(new Bus(112, 987, "Maria"));
		busses.add(new Bus(121, 321, "Jose"));
		busses.add(new Bus(211, 123, "Julian"));
		busses.add(new Bus(222, 456, "Lacerda"));
		busses.add(new Bus(221, 789, "Mujica"));
		busses.add(new Bus(212, 147, "Galeano"));
		busses.add(new Bus(122, 258, "Arthur"));
	}

	@Test
	void returnListFilteredByName() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(111, 654, "Joao"), new Bus(121, 321, "Jose"));

		// WHEN
		List<Bus> actual = busService.filterByName("Jo", busses);

		// THEN
		assertEquals(expected, actual);
	}
	
	

}
