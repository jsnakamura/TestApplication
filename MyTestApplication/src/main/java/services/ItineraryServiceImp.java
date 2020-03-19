package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.lucene.util.SloppyMath;

import entities.Itinerary;
import entities.Location;

public class ItineraryServiceImp implements ItineraryService {

	@Override
	public boolean createNewItinerary(int id, String name, String code, List<Location> locations,
			List<Itinerary> itineraries) {

		return itineraries.stream().filter(itinerary -> itinerary.getIdlinha() == id).findFirst().orElse(null) == null
				? itineraries.add(new Itinerary(id, name, code, locations))
				: false;
	}

	@Override
	public Itinerary getItinerary(int id, List<Itinerary> itineraries) {

		if (itineraries.isEmpty())
			return null;

		Itinerary itinerary = itineraries.stream().filter(streamItinerary -> streamItinerary.getIdlinha() == id)
				.findFirst().orElse(null);

		return itinerary != null
				? new Itinerary(itinerary.getIdlinha(), itinerary.getNome(), itinerary.getCodigo(),
						itinerary.getLocations())
				: null;
	}

	@Override
	public boolean updateItinerary(Itinerary itinerary, List<Itinerary> itineraries) {

		if (itineraries.isEmpty())
			return false;

		Itinerary updatedItinerary = itineraries.stream()
				.filter(streamItinerary -> streamItinerary.getIdlinha() == itinerary.getIdlinha()).findFirst()
				.orElse(null);

		if (updatedItinerary != null) {
			itineraries.set(itineraries.indexOf(updatedItinerary), new Itinerary(itinerary.getIdlinha(),
					itinerary.getNome(), itinerary.getCodigo(), itinerary.getLocations()));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteItinerary(int id, List<Itinerary> itineraries) {

		if (itineraries.isEmpty())
			return false;

		Itinerary deletedItinerary = itineraries.stream().filter(streamItinerary -> streamItinerary.getIdlinha() == id)
				.findFirst().orElse(null);

		return deletedItinerary != null ? itineraries.remove(deletedItinerary) : false;
	}

	@Override
	public List<Integer> filterBussesByRadius(double lat, double lng, double radius, List<Itinerary> itineraries) {

		List<Integer> filteredBusses = new ArrayList<Integer>();

		itineraries.stream().forEach(itinerary -> {

			List<Location> itiLocations = itinerary.getLocations();

			itiLocations.stream().forEach(location -> {
				
				double distance = SloppyMath.haversinMeters(lat, lng, location.getLat(), location.getLng()) / 1000;

				if (distance <= radius)
					filteredBusses.add(itinerary.getIdlinha());
			});
		});

		return filteredBusses.stream().distinct().collect(Collectors.toList());
	}

}
