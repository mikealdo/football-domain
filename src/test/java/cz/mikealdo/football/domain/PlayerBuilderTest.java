package cz.mikealdo.football.domain;

import cz.mikealdo.football.domain.builder.PlayerBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PlayerBuilderTest {

    PlayerBuilder builder;

    @Test
    public void shouldCreateBasicPlayer() throws Exception {
        String name = "name";
        int fotbalCzId = 234;
        int dressNumber = 10;
        builder = new PlayerBuilder(name, fotbalCzId, "Ú", dressNumber);

        Player player = builder.build();

        assertBasicAttributes(player, name, fotbalCzId, dressNumber, PlayerPosition.FORWARD);
    }

    private void assertBasicAttributes(Player player, String name, int fotbalCzId, int dressNumber, PlayerPosition playerPosition) {
        Assert.assertEquals(player.getName(), name);
        Assert.assertEquals(player.getId(), Integer.valueOf(fotbalCzId));
        Assert.assertEquals(player.getPlayerPosition(), playerPosition);
        Assert.assertEquals(player.getDressNumber(), Integer.valueOf(dressNumber));
    }

    @Test
    public void shouldCreateFullyPopulatedPlayer() throws Exception {
        String name = "name";
        int fotbalCzId = 234;
        int dressNumber = 10;
        builder = new PlayerBuilder(name, fotbalCzId, "Ú", dressNumber);

        Player player = builder
                .inMainLineUp(true)
                .captain(true)
                .firstSubstitutionMinute(Optional.of(1))
                .secondSubstitutionMinute(Optional.of(2))
                .redCardInMinute(Optional.of(3))
                .firstYellowCardInMinute(Optional.of(3))
                .secondYellowCardInMinute(Optional.of(4))
                .build();

        assertBasicAttributes(player, name, fotbalCzId, dressNumber, PlayerPosition.FORWARD);
        Assert.assertTrue(player.isCaptain());
        Assert.assertTrue(player.isInMainLineUp());
        Assert.assertEquals(player.getFirstSubstitutionMinute(), Integer.valueOf(1));
        Assert.assertEquals(player.getSecondSubstitutionMinute(), Integer.valueOf(2));
        Assert.assertEquals(player.getRedCardInMinute(), Integer.valueOf(3));
        Assert.assertEquals(player.getFirstYellowCardInMinute(), Integer.valueOf(3));
        Assert.assertEquals(player.getSecondYellowCardInMinute(), Integer.valueOf(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidPlayerPosition() throws Exception {
        new PlayerBuilder("", 1, "invalid", 1);
    }
}