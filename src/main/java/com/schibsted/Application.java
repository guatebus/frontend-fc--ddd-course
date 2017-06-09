package com.schibsted;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.player.PlayerService;
import com.schibsted.domain.treasure.GoldTreasure;
import com.schibsted.domain.treasure.Treasure;
import com.schibsted.domain.treasure.TreasureService;
import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.view.menu.CreatePlayerView;

import java.io.*;

public class Application {
    public static final Map MAP = new Map();

    public static void main(String[] args) throws IOException {
        final Reader reader = new InputStreamReader(System.in);
        final Writer writer = new PrintWriter(System.out);
        final Treasure treasure = new GoldTreasure(0, 250);

        MAP.addVisitor(treasure, 4, 6);

        final PlayerService playerService = new PlayerService();
        final TreasureService treasureService = new TreasureService(treasure);
        final ApplicationService applicationService = new ApplicationService(playerService, treasureService, MAP);

        final CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerService);
        final CreatePlayerView createPlayerView = new CreatePlayerView(reader, writer, createPlayerPresenter, applicationService);

        createPlayerView.show();
    }
}
