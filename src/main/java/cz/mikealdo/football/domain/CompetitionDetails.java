package cz.mikealdo.football.domain;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

public class CompetitionDetails {

	String competitionHash;
	String competitionName;
    String competitionDescription;
	List<Match> matches;
    List<PairedTeam> teams;
    Map<Integer, DateTime> roundDates;
    List<Arrival> arrivals;

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

    public List<PairedTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<PairedTeam> teams) {
        this.teams = teams;
    }

    public Map<Integer, DateTime> getRoundDates() {
        return roundDates;
    }

    public void setRoundDates(Map<Integer, DateTime> roundDates) {
        this.roundDates = roundDates;
    }

    public List<Arrival> getArrivals() {
		return arrivals;
	}

	public void setArrivals(List<Arrival> arrivals) {
		this.arrivals = arrivals;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

    public String getCompetitionHash() {
        return competitionHash;
    }

    public void setCompetitionHash(String competitionHash) {
        this.competitionHash = competitionHash;
    }

    public String getCompetitionDescription() {
        return competitionDescription;
    }

    public void setCompetitionDescription(String competitionDescription) {
        this.competitionDescription = competitionDescription;
    }
}
