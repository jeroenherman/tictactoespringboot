package be.leerstad.tictactoe.service.dto;

import be.leerstad.tictactoe.business.Seed;

public class PlayerDTO {
	private String name;
	private Seed Seed;
	private Integer score;
	
	public PlayerDTO(String name ) {
		this.name =name;
	}

	public PlayerDTO() {

	}

	public String getName() {
		return name;
	}
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Seed getSeed() {
		return Seed;
	}
	public void setSeed(Seed seed) {
		Seed = seed;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
