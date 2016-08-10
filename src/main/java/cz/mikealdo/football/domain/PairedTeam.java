package cz.mikealdo.football.domain;

import java.util.Optional;

public class PairedTeam {
    private Optional<Long> persistentId = Optional.empty();
    private Integer pairingId;
    private String pairingTeamName;

    public PairedTeam() {
    }

    public PairedTeam(Integer pairingId, String pairingTeamName) {
        this.pairingId = pairingId;
        this.pairingTeamName = pairingTeamName;
    }

    public Integer getPairingId() {
        return pairingId;
    }

    public String getPairingTeamName() {
        return pairingTeamName;
    }

    public Optional<Long> getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(Optional<Long> persistentId) {
        this.persistentId = persistentId;
    }

    @Override
    public String toString() {
        return "PairedTeam{" +
                "pairingId=" + pairingId +
                ", pairingTeamName='" + pairingTeamName + '\'' +
                '}';
    }
}
