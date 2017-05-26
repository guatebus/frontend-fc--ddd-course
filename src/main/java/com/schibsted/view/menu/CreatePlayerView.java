package com.schibsted.view.menu;

import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.view.View;

import java.io.Reader;
import java.io.Writer;

public class CreatePlayerView extends View {
    private final CreatePlayerPresenter presenter;

    public CreatePlayerView(Reader reader, Writer writer, CreatePlayerPresenter presenter) {
        super(reader, writer);

        this.presenter = (CreatePlayerPresenter) presenter.bindView(this);
    }

    @Override
    public void onRender() {
        getWriter().print("Enter player name: ");
        getWriter().flush();
    }

    @Override
    public void onCommand(String command) {
        presenter.onConfirmPlayerName(command);
    }

    public void onPlayerCreated() {

    }
}
