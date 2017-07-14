package com.schibsted.domain.shop;

import com.schibsted.domain.player.Player;

public class ShopService {
    private final Shop shop;

    public ShopService(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public Player purchase(Player player, String command) {
        shop.performPurchase(player, command);
        return player;
    }
}
