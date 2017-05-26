package com.schibsted.presenter;

import com.schibsted.view.View;

public abstract class Presenter<T extends View> {
    private T view;

    public Presenter bindView(T view) {
        this.view = view;
        return this;
    }

    protected final T getView() {
        return view;
    }
}