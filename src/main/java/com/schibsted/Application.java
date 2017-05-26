package com.schibsted;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.player.model.PlayerFactory;
import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.view.menu.CreatePlayerView;

import java.io.*;

public class Application {
    public static void main(String[] args) throws IOException {
        final Reader reader = new InputStreamReader(System.in);
        final Writer writer = new PrintWriter(System.out);

        PlayerFactory playerFactory = new PlayerFactory();
        ApplicationService applicationService = new ApplicationService(new Map());

        final CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerFactory);
        final CreatePlayerView createPlayerView = new CreatePlayerView(reader, writer, createPlayerPresenter, applicationService);

        createPlayerView.show();
    }
}
