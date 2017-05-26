package com.schibsted;

import com.schibsted.domain.player.model.PlayerFactory;
import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.view.menu.CreatePlayerView;

import java.io.*;

public class Application {
    public static void main(String[] args) throws IOException {
        final Reader reader = new InputStreamReader(System.in);
        final Writer writer = new PrintWriter(System.out);

        PlayerFactory playerFactory = new PlayerFactory();

        final CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerFactory);
        final CreatePlayerView createPlayerView = new CreatePlayerView(reader, writer, createPlayerPresenter);

        createPlayerView.show();
    }
}
