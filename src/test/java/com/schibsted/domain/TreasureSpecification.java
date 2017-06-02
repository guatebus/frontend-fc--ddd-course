package com.schibsted.domain;

import com.schibsted.domain.player.model.Player;
import com.schibsted.domain.treasure.EmptyTreasure;
import com.schibsted.domain.treasure.GoldTreasure;
import com.schibsted.domain.treasure.Treasure;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TreasureSpecification {
    private static final int GOLD_QT = 250;

    @Test
    public void should_add_gold_to_the_opener() throws Exception {
        Player opener = mock(Player.class);
        Treasure treasure = new GoldTreasure(GOLD_QT);
        treasure.open(opener);

        verify(opener).addGold(GOLD_QT);
    }

    @Test
    public void should_not_open_when_already_opened() throws Exception {
        Player opener = mock(Player.class);
        Treasure treasure = new EmptyTreasure();
        treasure.open(opener);

        verifyZeroInteractions(opener);
    }
}
