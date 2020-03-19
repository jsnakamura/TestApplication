package controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import entities.Bus;
import entities.Itinerary;
import entities.Location;
import services.BusService;
import services.ItineraryService;

public class MobilityController {


	private BusService busService;
	private ItineraryService itineraryService;
	private List<Bus> busses;
	private List<Itinerary> itineraries;

	public MobilityController(BusService busService, ItineraryService itineraryService, List<Bus> busses, List<Itinerary> itineraries) throws IOException, InterruptedException, URISyntaxException {
		this.busService = busService;
		this.itineraryService = itineraryService;
		this.busses = busses;
		this.itineraries = itineraries;
	}

	public List<Bus> filterBussesByName(String name) {
		return busService.filterByName(name, busses);
	}
	
	public List<Bus> listBusses() {
		return busses;
	}
	
	public List<Itinerary> listItineraries() {
		return itineraries;
	}

	public boolean upsertBusById(int id, String code, String name) {

		return busService.getBusById(id, busses) == null ? busService.createNewBus(id, code, name, busses)
				: busService.updateBusById(new Bus(id, code, name), busses);
	}

	public boolean upsertBusByCode(int id, String code, String name) {

		return busService.getBusByCode(code, busses) == null ? busService.createNewBus(id, code, name, busses)
				: busService.updateBusByCode(new Bus(id, code, name), busses);
	}

	public boolean upsertBusByName(int id, String code, String name) {

		return busService.getBusByName(name, busses) == null ? busService.createNewBus(id, code, name, busses)
				: busService.updateBusByName(new Bus(id, code, name), busses);
	}

	public Bus getBusById(int id) {

		return busService.getBusById(id, busses);
	}

	public Bus getBusByCode(String code) {

		return busService.getBusByCode(code, busses);
	}

	public Bus getBusByName(String name) {

		return busService.getBusByName(name, busses);
	}

	public boolean updateBusById(Bus bus) {

		return busService.updateBusById(bus, busses);
	}

	public boolean updateBusByCode(Bus bus) {

		return busService.updateBusByCode(bus, busses);
	}

	public boolean updateBusByName(Bus bus) {

		return busService.updateBusByName(bus, busses);
	}

	public boolean deleteBusById(int id) {

		return busService.deleteBusById(id, busses);
	}

	public boolean deleteBusByCode(String code) {

		return busService.deleteBusByCode(code, busses);
	}

	public boolean deleteBusByName(String name) {

		return busService.deleteBusByName(name, busses);
	}

	public boolean createNewItinerary(int id, String name, String code, List<Location> locations) {

		return itineraryService.getItinerary(id, itineraries) == null
				? itineraryService.createNewItinerary(id, name, code, locations, itineraries)
				: itineraryService.updateItinerary(new Itinerary(id, name, code, locations), itineraries);
	}

	public Itinerary getItinerary(int id) {

		return itineraryService.getItinerary(id, itineraries);
	}

	public boolean updateItinerary(Itinerary itinerary) {

		return itineraryService.updateItinerary(itinerary, itineraries);
	}

	public boolean deleteItinerary(int id) {

		return itineraryService.deleteItinerary(id, itineraries);
	}

	public List<Integer> filterBussesByRadius(double latOrigen, double lngOrigen, double radius) {

		return itineraryService.filterBussesByRadius(latOrigen, lngOrigen, radius, itineraries);
	}
}
