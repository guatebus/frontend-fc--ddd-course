package com.schibsted;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.player.model.PlayerFactory;
import com.schibsted.domain.treasure.EmptyTreasure;
import com.schibsted.domain.treasure.GoldTreasure;
import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.view.menu.CreatePlayerView;

import java.io.*;

public class Application {
    public static final Map MAP = new Map();

    public static void main(String[] args) throws IOException {
        final Reader reader = new InputStreamReader(System.in);
        final Writer writer = new PrintWriter(System.out);

        MAP.addVisitor(new GoldTreasure(250), 4, 6);
        MAP.addVisitor(new EmptyTreasure(), 2, 2);

        PlayerFactory playerFactory = new PlayerFactory();
        ApplicationService applicationService = new ApplicationService(MAP);

        final CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerFactory);
        final CreatePlayerView createPlayerView = new CreatePlayerView(reader, writer, createPlayerPresenter, applicationService);

        createPlayerView.show();
    }
}
