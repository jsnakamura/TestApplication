package entity;

import lombok.Data;

@Data
public class Bus {

	int id;
	int codigo;
	String nome;

	public Bus(int id, int codigo, String nome) {

		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}
}
