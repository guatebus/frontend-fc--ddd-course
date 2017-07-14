package com.schibsted;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.player.PlayerService;
import com.schibsted.domain.shop.Shop;
import com.schibsted.domain.treasure.*;
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
        final Treasure treasure3 = new ExperienceTreasure(2, 500);
        final Shop shop1 = new Shop(1);

        final PlayerService playerService = new PlayerService();
        final TreasureRepository treasureRepository = new InMemoryTreasureRepository();
        final RollDice rollDice = new SystemRollDice();

        MAP.addVisitor(treasure1, 4, 6);
        treasureRepository.save(treasure1);

        MAP.addVisitor(treasure2, 2, 3);
        treasureRepository.save(treasure2);

        MAP.addVisitor(treasure3, 1, 1);
        treasureRepository.save(treasure3);

        MAP.addVisitor(shop1, 3, 4);

        final TreasureService treasureService = new TreasureService(rollDice, treasureRepository);
        final ApplicationService applicationService = new ApplicationService(playerService, treasureService, MAP, shop1);

        final CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerService);
        final CreatePlayerView createPlayerView = new CreatePlayerView(reader, writer, createPlayerPresenter, applicationService);

        createPlayerView.show();
    }
}
