package com.schibsted.view.menu;

import com.schibsted.domain.shop.Shop;
import com.schibsted.view.View;
import java.io.Reader;
import java.io.Writer;

public class ShopView extends View {

    private final Shop shop;

    public ShopView(Reader reader, Writer writer, Shop shop) {
        super(reader, writer);
        this.shop = shop;
    }

    @Override
    public void onRender() {
        getWriter().println(shop.getShoppingList());
    }

    @Override
    public void onCommand(String command) {

    }
}
