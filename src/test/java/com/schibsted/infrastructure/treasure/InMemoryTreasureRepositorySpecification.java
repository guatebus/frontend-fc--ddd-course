package com.schibsted.infrastructure.treasure;

import com.schibsted.domain.treasure.EmptyTreasure;
import com.schibsted.domain.treasure.Treasure;
import com.schibsted.domain.treasure.TreasureRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InMemoryTreasureRepositorySpecification {
    TreasureRepository treasureRepository;

    @Before
    public void setUp() throws Exception {
        treasureRepository = new InMemoryTreasureRepository();
    }

    @Test
    public void ShouldGetTreasure() throws Exception {
        Treasure expectedTreasure = new EmptyTreasure(0);
        treasureRepository.save(expectedTreasure);

        Treasure treasure = treasureRepository.get(0);

        Assert.assertEquals(expectedTreasure, treasure);
    }
}
