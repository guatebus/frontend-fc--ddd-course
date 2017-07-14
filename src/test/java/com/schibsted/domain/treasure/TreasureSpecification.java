package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TreasureSpecification {
    private static final int GOLD_QT = 250;
    private static final int EXPERIENCE_QT = 500;
    private static final int NORMAL_ROLL_DICE = 11;

    @Test
    public void should_add_gold_to_the_opener() throws Exception {
        Player opener = mock(Player.class);
        Treasure treasure = new GoldTreasure(0, GOLD_QT);
        treasure.open(NORMAL_ROLL_DICE,opener);

        verify(opener).addGold(GOLD_QT);
    }

    @Test
    public void should_not_open_when_already_opened() throws Exception {
        Player opener = mock(Player.class);
        Treasure treasure = new EmptyTreasure(0);
        treasure.open(NORMAL_ROLL_DICE, opener);

        verifyZeroInteractions(opener);
    }

    @Test
    public void should_add_expirience_to_the_opener() throws Exception {
        Player opener = mock(Player.class);
        Treasure treasure = new ExperienceTreasure(0, EXPERIENCE_QT);
        treasure.open(NORMAL_ROLL_DICE, opener);

        verify(opener).addExperience(EXPERIENCE_QT);
    }
}
