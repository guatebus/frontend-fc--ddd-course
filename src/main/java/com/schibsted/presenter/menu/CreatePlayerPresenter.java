package com.schibsted.presenter.menu;

import com.schibsted.domain.model.PlayerFactory;
import com.schibsted.presenter.Presenter;
import com.schibsted.view.menu.CreatePlayerView;

public class CreatePlayerPresenter extends Presenter<CreatePlayerView> {
    private final PlayerFactory playerFactory;

    public CreatePlayerPresenter(PlayerFactory playerFactory) {
        super();
        this.playerFactory = playerFactory;
    }

    public void onConfirmPlayerName(String playerName) {
        System.out.println(">> " + playerName);
        playerFactory.create(playerName);
        getView().onPlayerCreated();
    }
}
