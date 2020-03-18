package entity;

import java.util.List;

import lombok.Data;

@Data
public class Itinerary {

	int idlinha;
	String nome;
	String codigo;
	List<Location> locations;
}
