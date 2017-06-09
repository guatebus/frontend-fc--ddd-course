package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TreasureServiceSpecification {

    private TreasureRepository repository;
    private Player player;
    private TreasureService service;
    private RollDice rollDice;

    @Before
    public void init() {
        repository = Mockito.mock(TreasureRepository.class);
        rollDice = Mockito.mock(RollDice.class);
        player = Mockito.mock(Player.class);
        rollDice = Mockito.mock(RollDice.class);
        service = new TreasureService(rollDice, repository);
    }

    @Test
    public void should_open_gold_treasure() throws Exception {
        Treasure treasure = new GoldTreasure(0,100);
        Treasure expectedTreasure = new EmptyTreasure(0);
        when(repository.get(0)).thenReturn(treasure);
        when(repository.save(expectedTreasure)).thenReturn(expectedTreasure);
        when(rollDice.roll()).thenReturn(11);

        Treasure openedTreasure = service.openTreasure(0, player);

        Assert.assertEquals(expectedTreasure, openedTreasure);

        verify(repository).save(expectedTreasure);
        verify(player).addGold(100);
    }

    @Test
    public void should_open_experience_treasure() throws Exception {
        Treasure treasure = new ExperienceTreasure(0,100);
        Treasure expectedTreasure = new EmptyTreasure(0);

        when(repository.get(0)).thenReturn(treasure);
        when(repository.save(expectedTreasure)).thenReturn(expectedTreasure);
        when(rollDice.roll()).thenReturn(11);

        Treasure openedTreasure = service.openTreasure(0, player);

        Assert.assertEquals(expectedTreasure, openedTreasure);

        verify(repository).save(expectedTreasure);
        verify(player).addExperience(100);

    }

    @Test
    public void should_not_add_experience_to_player_when_dice_roll_is_less_than_ten() throws Exception {
        Treasure treasure = new GoldTreasure(0,100);
        Treasure expectedTreasure = new EmptyTreasure(0);

        when(rollDice.roll()).thenReturn(9);
        when(repository.get(0)).thenReturn(treasure);
        when(repository.save(expectedTreasure)).thenReturn(expectedTreasure);

        Treasure openedTreasure = service.openTreasure(0, player);

        Assert.assertEquals(expectedTreasure, openedTreasure);

        verify(repository).save(expectedTreasure);
        verifyZeroInteractions(player);
    }

    @Test
    public void should_add_experience_to_player_and_keep_treasure_closed_when_dice_roll_is_more_than_eighty() throws Exception {
        Treasure treasure = new GoldTreasure(0,100);

        when(rollDice.roll()).thenReturn(81);
        when(repository.get(0)).thenReturn(treasure);
        when(repository.save(treasure)).thenReturn(treasure);

        Treasure openedTreasure = service.openTreasure(0, player);

        Assert.assertEquals(treasure, openedTreasure);

        verify(player).addGold(100);
    }

}
