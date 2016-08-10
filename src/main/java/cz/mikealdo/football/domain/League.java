package cz.mikealdo.football.domain;

import java.util.LinkedList;
import java.util.List;

public class League {
    private Long id;
    private Team teamForPair;
    private String name;
    private String description;
    private List<PairedTeam> teams = new LinkedList<>();
    private List<Match> matches = new LinkedList<>();

    public League(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeamForPair() {
        return teamForPair;
    }

    public void setTeamForPair(Team teamForPair) {
        this.teamForPair = teamForPair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PairedTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<PairedTeam> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
