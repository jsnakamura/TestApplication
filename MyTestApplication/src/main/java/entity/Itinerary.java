package entity;

import java.util.Map;

import lombok.Data;

@Data
public class Itinerary {

	int idlinha;
	String nome;
	int codigo;
	Map<Integer, Position> myPositions;
}
