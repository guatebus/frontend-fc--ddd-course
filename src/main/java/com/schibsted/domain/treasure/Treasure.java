package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.player.model.Player;

public interface Treasure extends Visitor {
    EmptyTreasure open(Player opener);
}
