package com.schibsted.infrastructure.treasure;

import com.schibsted.domain.treasure.EmptyTreasure;
import com.schibsted.domain.treasure.GoldTreasure;
import com.schibsted.domain.treasure.Treasure;
import com.schibsted.domain.treasure.TreasureRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTreasureRepository implements TreasureRepository {

    private Map<Integer, Treasure> treasures = new HashMap<>(2);

    @Override
    public Treasure get(int i) {
        return treasures.get(i);
    }

    @Override
    public Treasure save(Treasure treasure) {
        if (treasure instanceof GoldTreasure) {
            treasures.put(((GoldTreasure)treasure).getId(), treasure);
        } else {
            treasures.put(((EmptyTreasure)treasure).getId(), treasure);
        }
        return treasure;
    }
}
