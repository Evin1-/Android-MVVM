package com.example.myapplication;

import java.util.Arrays;

/**
 * Created by user on 11/1/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadResults() {
        view.showProgress();
        view.showResults(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        view.hideProgress();
    }
}
