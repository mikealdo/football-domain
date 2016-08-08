package cz.mikealdo.football.domain;

public class TeamName {

    private String pairingTeamName;
    private String niceLookingTeamName;
    private String innerClubTeamName;

    public TeamName(String pairingTeamName, String niceLookingTeamName, String innerClubTeamName) {
        this.pairingTeamName = pairingTeamName;
        this.niceLookingTeamName = niceLookingTeamName;
        this.innerClubTeamName = innerClubTeamName;
    }

    public String getPairingTeamName() {
        return pairingTeamName;
    }

    public String getNiceLookingTeamName() {
        return niceLookingTeamName;
    }

    public String getInnerClubTeamName() {
        return innerClubTeamName;
    }
}
