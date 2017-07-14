package com.schibsted.domain.treasure;

public interface TreasureRepository {
    Treasure get(int i);
    Treasure save(Treasure treasure);
}
