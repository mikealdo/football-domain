package cz.mikealdo.football.domain;

public class Arrival {
	
	Integer round;
	String time;

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Arrival{" +
				"round=" + round +
				", time=" + time +
				'}';
	}
}
