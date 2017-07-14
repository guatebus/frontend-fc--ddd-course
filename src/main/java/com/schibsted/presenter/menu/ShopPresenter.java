package com.schibsted.presenter.menu;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.shop.Shop;
import com.schibsted.presenter.Presenter;
import com.schibsted.view.menu.ShopView;

public class ShopPresenter extends Presenter<ShopView> {

    private final ApplicationService service;

    public ShopPresenter(ApplicationService service) {
        this.service = service;
    }

    public void onPurchase(String command) {
        service.onPurchase(command);
    }

    public String getShopMenu(Shop shop) {
        return shop.showItemListFor(service.getPlayer());
    }
}
