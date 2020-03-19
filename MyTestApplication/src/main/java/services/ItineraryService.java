package services;

import java.util.List;

import entities.Itinerary;
import entities.Location;

public interface ItineraryService {

	public boolean createNewItinerary(int id, String name, String code, List<Location> locations,
			List<Itinerary> itineraries);

	public Itinerary getItinerary(int id, List<Itinerary> itineraries);

	public boolean updateItinerary(Itinerary itinerary, List<Itinerary> itineraries);

	public boolean deleteItinerary(int id, List<Itinerary> itineraries);

	public List<Integer> filterBussesByRadius(double lat, double lng, double radius, List<Itinerary> itineraries);
}
