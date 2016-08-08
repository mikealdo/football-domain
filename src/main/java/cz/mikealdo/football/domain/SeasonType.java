package cz.mikealdo.football.domain;

import org.joda.time.DateTimeConstants;

public enum SeasonType {

	AUTUMN_SPRING(DateTimeConstants.AUGUST, DateTimeConstants.JUNE),
	SPRING_AUTUMN(DateTimeConstants.JUNE, DateTimeConstants.AUGUST);
		
	private int startMonth;
	private int endMonth;
	
	private SeasonType(int startMonth, int endMonth) {
		this.startMonth = startMonth;
		this.endMonth = endMonth;
	}

	public int getStartMonth() {
		return startMonth;
	}
	public int getEndMonth() {
		return endMonth;
	}
	
	public SeasonType getSeasonType() {
		return this;
	}


}
