/**
 * Copyright (c) 2012-2016, Rango.cz
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: no conditions.
 */
package cz.mikealdo.football.domain;

/***
 * Domain object for team.
 * @author Michal Davidek
 * @version 0.1
 * @since 0.1
 */
public class Team {
    private Long id;
    private Integer pairingId;
    private String description;
    private String preferredTeamName;
    private String clubInnerTeamName;
    private String pairingTeamName;

    public Team() {
    }

    public Team(Integer pairingId) {
        this.pairingId = pairingId;
    }

    public Team(Integer pairingId, String pairingTeamName) {
        this.pairingId = pairingId;
        this.pairingTeamName = pairingTeamName;
    }

    public Team(String nameToDisplay, String clubInnerTeamName, String pairingTeamName) {
        this.preferredTeamName = nameToDisplay;
        this.clubInnerTeamName = clubInnerTeamName;
        this.pairingTeamName = pairingTeamName;
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long id) {
        this.id = id;
    }

    public final Integer getPairingId() {
        return this.pairingId;
    }

    public final void setPairingId(Integer pairingId) {
        this.pairingId = pairingId;
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

    public final String getPairingTeamName() {
        return this.pairingTeamName;
    }

    public final void setPairingTeamName(String pairingTeamName) {
        this.pairingTeamName = pairingTeamName;
    }

    @Override
    public final String toString() {
        return
            "Team{"
                + "pairingId=" + this.pairingId
                + ", preferredTeamName='" + this.preferredTeamName + '\''
                + '}';
    }

    @Override
    public final boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Team that = (Team) object;
        return this.pairingId.equals(that.pairingId);
    }

    @Override
    public final int hashCode() {
        return this.pairingId.hashCode();
    }
}
