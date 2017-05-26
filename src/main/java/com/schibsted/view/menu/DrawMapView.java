package com.schibsted.view.menu;

import com.schibsted.domain.map.model.Map;
import com.schibsted.presenter.menu.DrawMapPresenter;
import com.schibsted.view.View;

import java.io.Reader;
import java.io.Writer;

public class DrawMapView extends View {

    private final DrawMapPresenter drawMapPresenter;

    public DrawMapView(Reader reader, Writer writer, DrawMapPresenter drawMapPresenter) {
        super(reader, writer);
        this.drawMapPresenter = (DrawMapPresenter) drawMapPresenter.bindView(this);
    }

    @Override
    public void onRender() {
        this.drawMapPresenter.onRefreshMap();
    }

    public void onRenderMap(Map map) {
        for (int x = map.UPPER_LEFT_BOUND.getX() - 1; x <= map.LOWER_RIGHT_BOUND.getX() + 1; x++) {
            for (int y = map.UPPER_LEFT_BOUND.getY() - 1; y <= map.LOWER_RIGHT_BOUND.getY() + 1; y++)
                if (isMapBoundary(map,x,y))
                    getWriter().print("#");
                else
                    if (isPlayerPosition(map.getPlayerPosition().getX(), map.getPlayerPosition().getY(), x, y))
                        getWriter().print("@");
                    else
                        getWriter().print(" ");
            getWriter().print("\n");
        }
        ;
        getWriter().print("Please move player: (l)eft, (r)ight, (u)p, (d)own.");
        getWriter().flush();
    }

    private boolean isPlayerPosition(int playerPositionX, int playerPositionY, int x, int y) {
        return x == playerPositionX && y == playerPositionY;
    }

    @Override
    public void onCommand(String command) {
        switch (command) {
            case "l":
                drawMapPresenter.moveLeft();
        }
    }

    private boolean isMapBoundary(Map map, int x, int y) {
        return x == map.UPPER_LEFT_BOUND.getX() - 1 || x == map.LOWER_RIGHT_BOUND.getX() + 1  ||
                ((x != map.UPPER_LEFT_BOUND.getX() - 1 && x != map.LOWER_RIGHT_BOUND.getX() + 1) && (y == map.UPPER_LEFT_BOUND.getY() - 1 ||y == map.LOWER_RIGHT_BOUND.getY() + 1));

    }
}
