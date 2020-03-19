package entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Itinerary {

	int idlinha;
	String nome;
	String codigo;
	List<Location> locations;
}
