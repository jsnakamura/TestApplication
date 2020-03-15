package entity;

import java.util.Map;

import lombok.Getter;

@Getter
public class itinerary {

	int idlinha;
	String nome;
	int codigo;
	Map<Integer, Position> myPositions;

	public itinerary(int idlinha, String nome, int codigo, Map<Integer, Position> myPositions) {

		this.idlinha = idlinha;
		this.nome = nome;
		this.codigo = codigo;
		this.myPositions = myPositions;
	}
}
