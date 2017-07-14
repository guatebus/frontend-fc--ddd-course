package com.schibsted.view.menu;

import com.schibsted.domain.shop.Shop;
import com.schibsted.presenter.menu.ShopPresenter;
import com.schibsted.view.View;
import java.io.Reader;
import java.io.Writer;

public class ShopView extends View {

    private final Shop shop;
    private final ShopPresenter shopPresenter;

    public ShopView(Reader reader, Writer writer, Shop shop, ShopPresenter shopPresenter) {
        super(reader, writer);
        this.shop = shop;
        this.shopPresenter = shopPresenter;
        shopPresenter.bindView(this);
    }

    @Override
    public void onRender() {
        getWriter().println(shopPresenter.getShopMenu(shop));
    }

    @Override
    public void onCommand(String command) {
        shopPresenter.onPurchase(command);
    }
}
