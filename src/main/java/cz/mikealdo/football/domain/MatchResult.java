package cz.mikealdo.football.domain;

import java.util.List;
import java.util.Objects;

public class MatchResult {

    private long homeGoals = 0;
    private long visitorGoals = 0;
    private boolean forfeited;
    private boolean resultEntered;
    private boolean penaltyShootout;
    private long homeGoalsInPenaltyShootout = 0;
    private long visitorGoalsInPenaltyShootout = 0;
    private long spectators;
    private List<Referee> referees;

    private List<Player> homeLineUp;
    private List<Player> visitorLineUp;
    private List<Goal> homeShooters;
    private List<Goal> visitorShooters;


    public MatchResult(String simpleResult) {
        simpleResult = simpleResult.trim();
        simpleResult = simpleResult.replaceAll(" ", "");
        String[] goals = simpleResult.split(":");
        if (goals.length != 2) {
            this.resultEntered = false;
            return;
        }
        this.homeGoals = Long.valueOf(goals[0]);
        this.visitorGoals = Long.valueOf(goals[1].replace("(K)", "").replace("p", ""));
        if (goals[1].contains("p")) {
            this.setPenaltyShootout(true);
        }
        this.resultEntered = true;
    }

    public MatchResult(String simpleResult, String penaltiesResult) {
        this(simpleResult);
        updateResultWithPenalties(penaltiesResult);
    }

    public void updateResultWithPenalties(String penaltiesResult) {
        String[] penaltyShootoutGoals = penaltiesResult.split(":");
        if (penaltyShootoutGoals.length != 3 && !penaltyShootoutGoals[0].equals("(PK")) {
            throw new IllegalArgumentException("Result is not parseable");
        }
        this.homeGoalsInPenaltyShootout = Long.valueOf(penaltyShootoutGoals[1]);
        this.visitorGoalsInPenaltyShootout = Long.valueOf(penaltyShootoutGoals[2].replace(")", ""));
        this.penaltyShootout = true;
    }

    public long getHomeGoals() {
        return homeGoals;
    }

    public long getVisitorGoals() {
        return visitorGoals;
    }

    public boolean isForfeited() {
        return forfeited;
    }

    public boolean isResultEntered() {
        return resultEntered;
    }

    public boolean isPenaltyShootout() {
        return penaltyShootout;
    }

    public long getHomeGoalsInPenaltyShootout() {
        return homeGoalsInPenaltyShootout;
    }

    public long getVisitorGoalsInPenaltyShootout() {
        return visitorGoalsInPenaltyShootout;
    }

    public boolean isDraw() {
        return Objects.equals(this.homeGoals, this.visitorGoals);
    }

    public void setHomeGoals(long homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setVisitorGoals(long visitorGoals) {
        this.visitorGoals = visitorGoals;
    }

    public void setForfeited(boolean forfeited) {
        this.forfeited = forfeited;
    }

    public void setResultEntered(boolean resultEntered) {
        this.resultEntered = resultEntered;
    }

    public void setPenaltyShootout(boolean penaltyShootout) {
        this.penaltyShootout = penaltyShootout;
    }

    public void setHomeGoalsInPenaltyShootout(long homeGoalsInPenaltyShootout) {
        this.homeGoalsInPenaltyShootout = homeGoalsInPenaltyShootout;
    }

    public void setVisitorGoalsInPenaltyShootout(long visitorGoalsInPenaltyShootout) {
        this.visitorGoalsInPenaltyShootout = visitorGoalsInPenaltyShootout;
    }

    public Long getSpectators() {
        return spectators;
    }

    public void setSpectators(Long spectators) {
        this.spectators = spectators;
    }

    public List<Referee> getReferees() {
        return referees;
    }

    public void setReferees(List<Referee> referees) {
        this.referees = referees;
    }

    public List<Player> getHomeLineUp() {
        return homeLineUp;
    }

    public void setHomeLineUp(List<Player> homeLineUp) {
        this.homeLineUp = homeLineUp;
    }

    public List<Player> getVisitorLineUp() {
        return visitorLineUp;
    }

    public void setVisitorLineUp(List<Player> visitorLineUp) {
        this.visitorLineUp = visitorLineUp;
    }

    public List<Goal> getHomeShooters() {
        return homeShooters;
    }

    public void setHomeShooters(List<Goal> homeShooters) {
        this.homeShooters = homeShooters;
    }

    public List<Goal> getVisitorShooters() {
        return visitorShooters;
    }

    public void setVisitorShooters(List<Goal> visitorShooters) {
        this.visitorShooters = visitorShooters;
    }

    public String prettyPrintSimpleResult() {
        long homeGoals = this.homeGoals;
        long visitorGoals = this.visitorGoals;
        if (penaltyShootout) {
            homeGoals = (homeGoalsInPenaltyShootout > visitorGoalsInPenaltyShootout) ? homeGoals + 1 : homeGoals;
            visitorGoals = (visitorGoalsInPenaltyShootout > homeGoalsInPenaltyShootout) ? visitorGoals + 1 : visitorGoals;
        }
        return (homeGoals) + ":" + (visitorGoals) + ((penaltyShootout) ? "p" : "") + ((forfeited) ? "k" : "");
    }
}
