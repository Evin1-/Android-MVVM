package com.example.myapplication;

import java.util.List;

/**
 * Created by user on 11/1/17.
 */

public interface MainContract {
    interface View {
        void showProgress();

        void showError(String error);

        void hideProgress();

        void showResults(List<String> strings);
    }

    interface Presenter {
        void attachView(View view);

        void detachView();

        void loadResults();
    }
}
