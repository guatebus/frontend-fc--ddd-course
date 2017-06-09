package com.schibsted.infrastructure.treasure;

import com.schibsted.domain.treasure.*;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTreasureRepository implements TreasureRepository {

    private Map<Integer, Treasure> treasures = new HashMap<>(10);

    @Override
    public Treasure get(int i) {
        return treasures.get(i);
    }

    @Override
    public Treasure save(Treasure treasure) {
        if (treasure instanceof GoldTreasure) {
            treasures.put(((GoldTreasure)treasure).getId(), treasure);
        } else if(treasure instanceof EmptyTreasure) {
            treasures.put(((EmptyTreasure)treasure).getId(), treasure);
        } else {
            treasures.put(((ExperienceTreasure)treasure).getId(), treasure);
        }
        return treasure;
    }
}
