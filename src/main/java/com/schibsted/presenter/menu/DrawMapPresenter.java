package com.schibsted.presenter.menu;

import com.schibsted.application.ApplicationService;
import com.schibsted.presenter.Presenter;
import com.schibsted.view.menu.DrawMapView;

public class DrawMapPresenter extends Presenter<DrawMapView> {

    private final ApplicationService service;

    public DrawMapPresenter(ApplicationService service) {
        this.service = service;
    }

    public void moveLeft() {
        service.movePlayerLeft();
    }

    public void onRefreshMap() {
        getView().onRenderMap(service.getMap());
    }
}
