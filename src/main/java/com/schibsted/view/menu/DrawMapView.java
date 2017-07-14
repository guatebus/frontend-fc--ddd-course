package com.schibsted.view.menu;

import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;
import com.schibsted.domain.shop.Shop;
import com.schibsted.presenter.menu.DrawMapPresenter;
import com.schibsted.view.View;

import java.io.Reader;
import java.io.Writer;
import java.util.Optional;

public class DrawMapView extends View {

    private final DrawMapPresenter drawMapPresenter;

    private enum CollisionType {NONE, TREASURE, SHOP};
    private CollisionType currentCollision;
    private Optional<Integer> treasureId;
    private Optional<Integer> currentShopId;

    public DrawMapView(Reader reader, Writer writer, DrawMapPresenter drawMapPresenter) {
        super(reader, writer);
        this.drawMapPresenter = (DrawMapPresenter) drawMapPresenter.bindView(this);
        currentCollision = CollisionType.NONE;
    }

    @Override
    public void onRender() {
        this.drawMapPresenter.onRefreshMap();
    }

    public void onRenderPlayer(Player player) {
        getWriter().printf("%s - %dG\n", player.getName(), player.getGold());
        getWriter().printf("Level %d - %dEXP - %dHP\n", player.getLevel(), player.getExperience(), player.getHitPoints());
    }

    public void onRenderMap(Map map) {
        for (int y = map.UPPER_LEFT_BOUND.getY() - 1; y <= map.LOWER_RIGHT_BOUND.getY() + 1; y++) {
            for (int x = map.UPPER_LEFT_BOUND.getX() - 1; x <= map.LOWER_RIGHT_BOUND.getX() + 1; x++)
                if (isMapBoundary(map, x, y)) {
                    getWriter().print("#");
                } else if (isPlayerPosition(map.getPlayerPosition().getX(), map.getPlayerPosition().getY(), x, y)) {
                    getWriter().print("@");
                } else {
                    printMapTile(map, x, y);
                }
            getWriter().print("\n");
        }

        getWriter().println("Please move player: (l)eft, (r)ight, (u)p, (d)own.");
        if (currentCollision == CollisionType.TREASURE) {
            getWriter().println("(O)pen treasure.");
        } else if (currentCollision == CollisionType.SHOP) {
            getWriter().println("(B)uy items.");
        }
    }

    private void printMapTile(Map map, int x, int y) {
        final VisitorReference visitor = map.visitors.stream()
                .filter(ref -> ref.position.is(x, y))
                .findFirst().orElse(null);

        if (visitor == null) {
            getWriter().print(" ");
        } else if (visitor.type == Visitor.Type.CLOSED_TREASURE.ordinal()) {
            getWriter().print("$");
        } else if (visitor.type == Visitor.Type.OPEN_TREASURE.ordinal()) {
            getWriter().print("#");
        } else if (visitor.type == Visitor.Type.SHOP.ordinal()) {
            getWriter().print("H");
        }
    }

    private boolean isPlayerPosition(int playerPositionX, int playerPositionY, int x, int y) {
        return x == playerPositionX && y == playerPositionY;
    }

    @Override
    public void onCommand(String command) {
        if (command.equals("o") && currentCollision == CollisionType.TREASURE) {
            drawMapPresenter.onOpenTreasure(treasureId.get());
            currentCollision = CollisionType.NONE;
        } else if (command.equals("b") && currentCollision == CollisionType.SHOP) {
            drawMapPresenter.onBuyFromShop(currentShopId.get());
        } else {
            currentCollision = CollisionType.NONE;
            treasureId = Optional.empty();
            drawMapPresenter.move(command);
        }
    }

    private boolean isMapBoundary(Map map, int x, int y) {
        return x == map.UPPER_LEFT_BOUND.getX() - 1 || x == map.LOWER_RIGHT_BOUND.getX() + 1 ||
                ((x != map.UPPER_LEFT_BOUND.getX() - 1 && x != map.LOWER_RIGHT_BOUND.getX() + 1) && (y == map.UPPER_LEFT_BOUND.getY() - 1 || y == map.LOWER_RIGHT_BOUND.getY() + 1));

    }

    public void onTreasureChestFound(int treasureId) {
        this.treasureId = Optional.of(treasureId);
        currentCollision = CollisionType.TREASURE;
    }

    public void onShopFound(int shopId) {
        currentShopId = Optional.of(shopId);
        currentCollision = CollisionType.SHOP;
    }

    public void navigateToShop(Shop shop) {
        navigateTo(new ShopView(getReader(), getWriter(), shop));
    }
}
