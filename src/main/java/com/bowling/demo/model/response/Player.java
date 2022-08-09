package com.bowling.demo.model.response;

public class Player {
	private String name;
	private int score;
	private boolean isPerfect;

	public Player(String name, int score, boolean isPerfect) {
		this.name = name;
		this.score = score;
		this.isPerfect = isPerfect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPerfect() {
		return isPerfect;
	}

	public void setPerfect(boolean isPerfect) {
		this.isPerfect = isPerfect;
	}
}
