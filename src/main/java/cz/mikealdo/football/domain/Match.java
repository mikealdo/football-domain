package cz.mikealdo.football.domain;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.util.Optional;

public class Match {

    DateTime date;
    Team homeTeam;
    Team visitorTeam;
    Optional<MatchResult> result = Optional.empty();
    Integer round;
    private LocalTime arrivalTime;

    public Match() {
    }

    public Match(Integer round, Integer homeTeamPairingId, Integer visitorTeamPairingId) {
        this.homeTeam = new Team(homeTeamPairingId);
        this.visitorTeam = new Team(visitorTeamPairingId);
        this.round = round;
    }

    public Match(DateTime date, Team homeTeam, Team visitorTeam, MatchResult result, Integer round) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
        this.result = Optional.of(result);
        this.round = round;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Optional<MatchResult> getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = Optional.of(new MatchResult(result));
    }

    public void setResult(MatchResult result) {
        this.result = Optional.of(result);
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match that = (Match) o;

        if (!homeTeam.equals(that.homeTeam)) return false;
        if (!visitorTeam.equals(that.visitorTeam)) return false;
        return round.equals(that.round);

    }

    @Override
    public int hashCode() {
        int result = homeTeam.hashCode();
        result = 31 * result + visitorTeam.hashCode();
        result = 31 * result + round.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "date=" + date +
                ", homeTeam=" + homeTeam +
                ", visitorTeam=" + visitorTeam +
                ", round=" + round +
                ", result='" + result + '\'' +
                '}';
    }
}
