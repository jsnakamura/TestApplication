package views;

import java.io.IOException;
import java.net.URISyntaxException;

import entities.Itinerary;
import helpers.DataHelper;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

		DataHelper dataHelper = new DataHelper();

		Itinerary itinerary = dataHelper
				.getItineraryFromJson("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=5529");

		System.out.println(itinerary);

	}
}
