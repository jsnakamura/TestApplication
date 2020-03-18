package helper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import entity.Bus;
import entity.Itinerary;
import entity.Location;

public class DataHelper {

	private Gson gson = new Gson();

	private HttpClient httpClient = new HttpClient();

	public Bus[] getBussesFromGson() throws IOException, InterruptedException, URISyntaxException {

		String response = httpClient.get("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%25&t=o");

		return gson.fromJson(response, Bus[].class);
	}

	public Itinerary getItineraryFromGson() throws IOException, InterruptedException, URISyntaxException {

		String response = httpClient.get("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=5566");

		JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
		
		Itinerary itinerary = new Itinerary();
		
		List<Location> locationsList = new ArrayList<Location>();
		
		
		itinerary.setIdlinha(jsonObject.get("idlinha").getAsInt());
		
		itinerary.setNome(jsonObject.get("nome").getAsString());
		
		itinerary.setCodigo(jsonObject.get("codigo").getAsString());
		
		jsonObject.remove("idlinha");
		jsonObject.remove("nome");
		jsonObject.remove("codigo");
		
		jsonObject.entrySet().forEach(entry -> {
			
			Location location = new Location();
			
			JsonObject streamJsonObject = gson.fromJson(entry.getValue(), JsonObject.class);
			
			location.setId(Integer.valueOf(entry.getKey()));
			location.setLat(streamJsonObject.get("lat").getAsDouble());
			location.setLng(streamJsonObject.get("lng").getAsDouble());

			locationsList.add(location);	
		});
		
		itinerary.setLocations(locationsList);
		return itinerary;
	}
}
