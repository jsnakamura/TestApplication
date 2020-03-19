package controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Bus;
import entities.Itinerary;
import entities.Location;
import services.BusService;
import services.BusServiceImp;
import services.ItineraryService;
import services.ItineraryServiceImp;

class MobilityControllerTest {

	BusService busService;
	List<Bus> busses;
	ItineraryService itineraryService;
	List<Itinerary> itineraries;
	MobilityController mobilityController;

	@BeforeEach
	void init() throws IOException, InterruptedException, URISyntaxException {
		busService = new BusServiceImp();
		busses = new ArrayList<Bus>();
		itineraryService = new ItineraryServiceImp();
		itineraries = new ArrayList<Itinerary>();

		busses.add(new Bus(111, "654", "Joao"));
		busses.add(new Bus(112, "987", "Maria"));

		itineraries.add(new Itinerary(5566, "GRUTINHA", "270-2",
				Arrays.asList(new Location(0, -15.2, 15.8), new Location(1, -8.6, -15.3))));

		mobilityController = new MobilityController(busService, itineraryService, busses, itineraries);
	}

	@Test
	void createBusWhenNoElementById() {

		// GIVEN
		List<Bus> expected = new ArrayList<Bus>();

		expected.add(new Bus(111, "654", "Joao"));
		expected.add(new Bus(112, "987", "Maria"));
		expected.add(new Bus(999, "code", "a Name"));

		// When
		mobilityController.upsertBusById(999, "code", "a Name");

		// THEN
		assertEquals(expected, mobilityController.listBusses());
	}

	@Test
	void updateBusWhenExistsElementById() {

		// GIVEN
		List<Bus> expected = new ArrayList<Bus>();

		expected.add(new Bus(111, "code", "a Name"));
		expected.add(new Bus(112, "987", "Maria"));

		// When
		mobilityController.upsertBusById(111, "code", "a Name");

		// THEN
		assertEquals(expected, mobilityController.listBusses());
	}

	@Test
	void createBusWhenNoElementByCode() {

		// GIVEN
		List<Bus> expected = new ArrayList<Bus>();

		expected.add(new Bus(111, "654", "Joao"));
		expected.add(new Bus(112, "987", "Maria"));
		expected.add(new Bus(999, "code", "a Name"));

		// When
		mobilityController.upsertBusByCode(999, "code", "a Name");

		// THEN
		assertEquals(expected, mobilityController.listBusses());
	}

	@Test
	void updateBusWhenExistsElementByCode() {

		// GIVEN
		List<Bus> expected = new ArrayList<Bus>();

		expected.add(new Bus(333, "654", "a Name"));
		expected.add(new Bus(112, "987", "Maria"));

		// When
		mobilityController.upsertBusByCode(333, "654", "a Name");

		// THEN
		assertEquals(expected, mobilityController.listBusses());
	}

	@Test
	void createBusWhenNoElementByName() {

		// GIVEN
		List<Bus> expected = new ArrayList<Bus>();

		expected.add(new Bus(111, "654", "Joao"));
		expected.add(new Bus(112, "987", "Maria"));
		expected.add(new Bus(999, "code", "a Name"));

		// When
		mobilityController.upsertBusByName(999, "code", "a Name");

		// THEN
		assertEquals(expected, mobilityController.listBusses());
	}

	@Test
	void updateBusWhenExistsElementByName() {

		// GIVEN
		List<Bus> expected = new ArrayList<Bus>();
		expected.add(new Bus(333, "code", "Joao"));
		expected.add(new Bus(112, "987", "Maria"));

		// When
		mobilityController.upsertBusByName(333, "code", "Joao");

		// THEN
		assertEquals(expected, mobilityController.listBusses());
	}

	// itineraries.add(new Itinerary(5566, "GRUTINHA", "270-2", Arrays.asList(new
	// Location(0, -15.2, 15.8), new Location(1, -8.6, -15.3))));

	@Test
	void createItineraryWhenNoElement() {

		// GIVEN
		List<Itinerary> expected = new ArrayList<Itinerary>();

		expected.add(new Itinerary(5566, "GRUTINHA", "270-2",
				Arrays.asList(new Location(0, -15.2, 15.8), new Location(1, -8.6, -15.3))));
		expected.add(new Itinerary(123, "a Name", "T4",
				Arrays.asList(new Location(0, -10.0, 10.0), new Location(1, -8.0, -8.0))));

		// WHEN
		mobilityController.createNewItinerary(123, "a Name", "T4",
				Arrays.asList(new Location(0, -10.0, 10.0), new Location(1, -8.0, -8.0)));

		// THEN
		assertEquals(expected, mobilityController.listItineraries());
	}

	@Test
	void updateItineraryWhenElementExists() {

		// GIVEN
		List<Itinerary> expected = new ArrayList<Itinerary>();

		expected.add(new Itinerary(5566, "TERMINAL", "T4",
				Arrays.asList(new Location(0, -10.10, 15.8), new Location(1, -10.10, -15.3))));

		// WHEN
		mobilityController.createNewItinerary(5566, "TERMINAL", "T4",
				Arrays.asList(new Location(0, -10.10, 15.8), new Location(1, -10.10, -15.3)));

		// THEN
		assertEquals(expected, mobilityController.listItineraries());
	}

}
