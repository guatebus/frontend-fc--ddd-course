package com.schibsted.presenter.menu;

import com.schibsted.presenter.Presenter;
import com.schibsted.view.menu.CreatePlayerView;

public class CreatePlayerPresenter extends Presenter<CreatePlayerView> {
    public void onConfirmPlayerName(String playerName) {
        System.out.println(">> " + playerName);
        getView().onPlayerCreated();
    }
}
