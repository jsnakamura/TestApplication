package helpers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import entities.Bus;
import entities.Itinerary;
import entities.Location;

public class DataHelper {

	private Gson gson = new Gson();

	private HttpClient httpClient = new HttpClient();

	public List<Bus> getBussesFromJson(String url) throws IOException, InterruptedException, URISyntaxException {

		String response = httpClient.get(url);

		return Arrays.asList(gson.fromJson(response, Bus[].class));
	}

	private Itinerary getItineraryFromJson(String url) throws IOException, InterruptedException, URISyntaxException {

		String response = httpClient.get(url);

		JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

		Itinerary itinerary = gson.fromJson(response, Itinerary.class);

		List<Location> locationsList = new ArrayList<Location>();

		jsonObject.remove("idlinha");
		jsonObject.remove("nome");
		jsonObject.remove("codigo");

		jsonObject.entrySet().forEach(entry -> {

			Location location = gson.fromJson(entry.getValue(), Location.class);
			location.setId(Integer.valueOf(entry.getKey()));

			locationsList.add(location);
		});

		itinerary.setLocations(locationsList);
		return itinerary;
	}
	
	public List<Itinerary> getItineraries(List<Bus> busses) {
		
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		
		busses.forEach(bus -> {
			
			String url = "http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + bus.getId();
			
			try {
				itineraries.add(getItineraryFromJson(url));
			} catch (IOException | InterruptedException | URISyntaxException e) {
				e.printStackTrace();
			}
		});
		
		return itineraries;
	}
}
