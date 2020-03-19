package views;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import controllers.MobilityController;
import entities.Bus;
import entities.Itinerary;
import helpers.DataHelper;
import services.BusServiceImp;
import services.ItineraryServiceImp;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		
		DataHelper dataHelper = new DataHelper();
		
		List<Bus> busses = dataHelper.getBussesFromJson("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%25&t=o");
		List<Itinerary> itineraries = dataHelper.getItineraries(busses);
		
		MobilityController mobilityController= new MobilityController(new BusServiceImp(), new ItineraryServiceImp(), busses, itineraries);
	}
}
