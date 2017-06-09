package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TreasureServiceSpecification {

    private TreasureRepository repository;

    @Before
    public void init() {
        repository = Mockito.mock(TreasureRepository.class);
    }

    @Test
    public void should_open_gold_treasure() throws Exception {
        Treasure treasure = new GoldTreasure(0,100);
        Treasure expectedTreasure = new EmptyTreasure(0);
        Player player = Mockito.mock(Player.class);
        when(repository.get(0)).thenReturn(treasure);
        when(repository.save(expectedTreasure)).thenReturn(expectedTreasure);
        TreasureService service = new TreasureService(repository);

        Treasure openedTreasure = service.openTreasure(0, player);

        Assert.assertEquals(expectedTreasure, openedTreasure);

        verify(repository).save(expectedTreasure);
        verify(player).addGold(100);
    }

    @Test
    public void should_open_experience_treasure() throws Exception {
        Treasure treasure = new ExperienceTreasure(0,100);
        Treasure expectedTreasure = new EmptyTreasure(0);
        Player player = Mockito.mock(Player.class);
        when(repository.get(0)).thenReturn(treasure);
        when(repository.save(expectedTreasure)).thenReturn(expectedTreasure);
        TreasureService service = new TreasureService(repository);

        Treasure openedTreasure = service.openTreasure(0, player);

        Assert.assertEquals(expectedTreasure, openedTreasure);

        verify(repository).save(expectedTreasure);
        verify(player).addExperience(100);

    }
}
