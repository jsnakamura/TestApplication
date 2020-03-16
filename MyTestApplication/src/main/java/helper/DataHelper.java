package helper;

import java.io.IOException;
import java.net.URISyntaxException;

import com.google.gson.Gson;

import entity.Bus;
import entity.Itinerary;

public class DataHelper {

	private Gson gson = new Gson();

	private HttpClient httpClient = new HttpClient();

	public Bus[] getBussesFromGson() throws IOException, InterruptedException, URISyntaxException {

		String response = httpClient.get("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%25&t=o");

		return gson.fromJson(response, Bus[].class);
	}

	public Itinerary getItineraryFromGson() throws IOException, InterruptedException, URISyntaxException {

		String response = httpClient.get("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=5566");

		return gson.fromJson(response, Itinerary.class);
	}
}
