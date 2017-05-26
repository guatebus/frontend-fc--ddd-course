package com.schibsted.presenter.menu;

import com.schibsted.domain.model.PlayerFactory;
import com.schibsted.view.View;
import com.schibsted.view.menu.CreatePlayerView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CreatePlayerPresenterSpecification {

    private final String A_PLAYER = "A_PLAYER";

    @Test
    public void should_create_a_player() throws Exception {
        PlayerFactory playerFactory = Mockito.mock(PlayerFactory.class);
        CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerFactory);
        createPlayerPresenter.bindView(Mockito.mock(CreatePlayerView.class));

        createPlayerPresenter.onConfirmPlayerName(A_PLAYER);

        verify(playerFactory, times(1)).create(A_PLAYER);
    }
}
