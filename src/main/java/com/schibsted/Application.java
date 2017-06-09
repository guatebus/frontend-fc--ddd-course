package com.schibsted;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.player.PlayerService;
import com.schibsted.domain.treasure.GoldTreasure;
import com.schibsted.domain.treasure.Treasure;
import com.schibsted.domain.treasure.TreasureRepository;
import com.schibsted.domain.treasure.TreasureService;
import com.schibsted.infrastructure.treasure.InMemoryTreasureRepository;
import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.view.menu.CreatePlayerView;

import java.io.*;

public class Application {
    public static final Map MAP = new Map();

    public static void main(String[] args) throws IOException {
        final Reader reader = new InputStreamReader(System.in);
        final Writer writer = new PrintWriter(System.out);
        final Treasure treasure1 = new GoldTreasure(0, 250);
        final Treasure treasure2 = new GoldTreasure(1, 500);

        MAP.addVisitor(treasure1, 4, 6);

        final PlayerService playerService = new PlayerService();
        final TreasureRepository treasureRepository = new InMemoryTreasureRepository();

        MAP.addVisitor(treasure1, 4, 6);
        treasureRepository.save(treasure1);

        MAP.addVisitor(treasure2, 2, 3);
        treasureRepository.save(treasure2);


        final TreasureService treasureService = new TreasureService(treasureRepository);
        final ApplicationService applicationService = new ApplicationService(playerService, treasureService, MAP);

        final CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerService);
        final CreatePlayerView createPlayerView = new CreatePlayerView(reader, writer, createPlayerPresenter, applicationService);

        createPlayerView.show();
    }
}
