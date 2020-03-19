package services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Itinerary;
import entities.Location;

class ItineraryServiceTest {

	ItineraryService itineraryService;
	List<Itinerary> itineraries;

	@BeforeEach
	void init() {

		itineraryService = new ItineraryServiceImp();
		itineraries = new ArrayList<Itinerary>();

		itineraries.add(new Itinerary(5566, "GRUTINHA", "270-2",
				Arrays.asList(new Location(0, -30.03091377535200000, -51.22586636214200000),
						new Location(1, -30.03098677535200000, -51.22481036214200000),
						new Location(2, -30.03103177535200000, -51.22435136214200000),
						new Location(3, -30.03106977535200000, -51.22425536214200000),
						new Location(4, -30.03112777535200000, -51.22418836214200000),
						new Location(5, -30.03146877535200000, -51.22392336214200000),
						new Location(6, -30.03191877535200000, -51.22357636214200000))));

		itineraries.add(new Itinerary(5529, "1 DE MAIO", "250-1",
				Arrays.asList(new Location(0, -30.09143577535200000, -51.17800136214200000),
						new Location(1, -30.09133477535200000, -51.17815036214200000),
						new Location(2, -30.09113177535200000, -51.17852136214200000),
						new Location(3, -30.09092277535200000, -51.17863436214200000),
						new Location(4, -30.09038077535200000, -51.17904436214200000),
						new Location(5, -30.09008077535200000, -51.17934636214200000),
						new Location(6, -30.08989377535200000, -51.17945836214200000))));
		
		itineraries.add(new Itinerary(5865, "TERMINAL ANTONIO DE CARVALHO\\/3 PERIMETRAL", "\"T11A-1",
				Arrays.asList(new Location(0, -30.06573777535200000, -51.15063936214200000),
						new Location(1, -30.06560277535200000, -51.15134436214200000),
						new Location(2, -30.06551377535200000, -51.15155336214200000),
						new Location(3, -30.06539077535200000, -51.15187936214200000),
						new Location(4, -30.06532577535200000, -51.15211236214200000),
						new Location(5, -30.06528277535200000, -51.15230236214200000),
						new Location(6, -30.06525577535200000, -51.15259136214200000))));
		
		itineraries.add(new Itinerary(5504, "TRANSVERSAL 4", "T4-1",
				Arrays.asList(new Location(0, -30.00868777535200000, -51.14298036214200000),
						new Location(1, -30.00898177535200000, -51.14341536214200000),
						new Location(2, -30.00916777535200000, -51.14377336214200000),
						new Location(3, -30.00955077535200000, -51.14430136214200000),
						new Location(4, -30.00977277535200000, -51.14469136214200000),
						new Location(5, -30.00984277535200000, -51.14485736214200000),
						new Location(6, -30.01018177535200000, -51.14560936214200000))));
		
		itineraries.add(new Itinerary(5224, "RUBEM BERTA (SERTORIO)", "762-1",
				Arrays.asList(new Location(0, -30.02046377535200000, -51.10052136214200000),
						new Location(1, -30.02048777535200000, -51.10087736214200000),
						new Location(2, -30.02052577535200000, 51.10142936214200000),
						new Location(3, -30.02054477535200000, -51.10167936214200000),
						new Location(4, -30.02056577535200000, -51.10198236214200000),
						new Location(5, -30.02062277535200000, -51.10236036214200000),
						new Location(6, -30.02070077535200000, -51.10280036214200000))));

	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
