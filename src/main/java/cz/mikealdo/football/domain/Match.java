package cz.mikealdo.football.domain;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.util.Optional;

public class Match {

    DateTime date;
    PairedTeam homeTeam;
    PairedTeam visitorTeam;
    Optional<MatchResult> result = Optional.empty();
    Integer round;
    private LocalTime arrivalTime;

    public Match() {
    }

    public Match(DateTime date, PairedTeam homeTeam, PairedTeam visitorTeam, MatchResult result, Integer round) {
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

    public PairedTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(PairedTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public PairedTeam getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(PairedTeam visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Optional<MatchResult> getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = Optional.of(new MatchResult(result));
    }

//    public void setResult(MatchResult result) {
//        this.result = Optional.of(result);
//    }

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

        return homeTeam.equals(that.homeTeam) && visitorTeam.equals(that.visitorTeam) && round.equals(that.round);

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
