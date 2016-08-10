/**
 * Copyright (c) 2012-2016, Rango.cz
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: no conditions.
 */
package cz.mikealdo.football.domain;

import java.util.Optional;

/***
 * Domain object for team.
 * @author Michal Davidek
 * @version 0.1
 * @since 0.1
 */
public class Team {
    private Long id;
    private String description;
    private String preferredTeamName;
    private String clubInnerTeamName;
    private Optional<PairedTeam> pairedTeam;

    public Team() {
    }

    public Team(PairedTeam pairedTeam) {
        this.pairedTeam = Optional.of(pairedTeam);
    }


    public Team(String nameToDisplay, String clubInnerTeamName) {
        this.preferredTeamName = nameToDisplay;
        this.clubInnerTeamName = clubInnerTeamName;
    }

    public final boolean isTeamForPairPresent() {
        return this.pairedTeam.isPresent();
    }

    public final boolean isTeamFullyPopulated() {
        return id != null && !description.isEmpty() && !preferredTeamName.isEmpty() && !clubInnerTeamName.isEmpty() && pairedTeam.isPresent();
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long id) {
        this.id = id;
    }

    public final String getPreferredTeamName() {
        return this.preferredTeamName;
    }

    public final void setPreferredTeamName(String preferredTeamName) {
        this.preferredTeamName = preferredTeamName;
    }

    public final String getClubInnerTeamName() {
        return this.clubInnerTeamName;
    }

    public final void setClubInnerTeamName(final String clubInnerTeamName) {
        this.clubInnerTeamName = clubInnerTeamName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public Optional<PairedTeam> getPairedTeam() {
        return pairedTeam;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", pairedTeam=" + pairedTeam +
                ", preferredTeamName='" + preferredTeamName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return id.equals(team.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
