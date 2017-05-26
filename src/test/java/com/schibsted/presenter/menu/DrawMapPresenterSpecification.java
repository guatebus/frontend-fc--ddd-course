package com.schibsted.presenter.menu;

import com.schibsted.application.ApplicationService;
import com.schibsted.view.menu.DrawMapView;
import org.junit.Test;
import org.mockito.Mockito;

public class DrawMapPresenterSpecification {

    @Test
    public void should_move_a_player_to_the_left() throws Exception {
        ApplicationService service = Mockito.mock(ApplicationService.class);
        DrawMapPresenter drawMapPresenter = new DrawMapPresenter(service);
        DrawMapView drawMapView = Mockito.mock(DrawMapView.class);
        drawMapPresenter.bindView(drawMapView);

        drawMapPresenter.moveLeft();

        Mockito.verify(service, Mockito.times(1)).movePlayerLeft();
    }
}
