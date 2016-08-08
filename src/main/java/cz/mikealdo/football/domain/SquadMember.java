package cz.mikealdo.football.domain;

public class SquadMember {

    private final Integer id;
    private final String name;

	public SquadMember(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

    public Integer getId() {
        return id;
    }

	public String getName() {
		return name;
	}
}
