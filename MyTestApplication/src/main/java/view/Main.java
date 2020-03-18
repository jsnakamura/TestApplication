package view;

import java.io.IOException;
import java.net.URISyntaxException;
import entity.Itinerary;
import helper.DataHelper;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

		DataHelper dataHelper = new DataHelper();


		Itinerary itinerary = dataHelper.getItineraryFromGson();

		System.out.println(itinerary);

	}

}
