package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.mylibrary.ViewModel;

/**
 * Created by user on 11/1/17.
 */

class MainViewModel extends ViewModel {
    public MainViewModel(@Nullable State savedInstanceState) {
        super(savedInstanceState);
    }

    public void onClickBtnClicks(Activity activity) {
        final Intent intent = new Intent(activity, ClickCountActivity.class);
        activity.startActivity(intent);
    }

    public void onClickBtnRecycler(Activity activity) {
        // TODO: 11/1/17
//        final Intent intent = new Intent(activity, AndroidVersionsActivity.class);
//        activity.startActivity(intent);
    }

    public void onClickHiBrianLee(Activity activity) {
        try {
            Intent intent = Intent.parseUri("https://www.twitter.com/evin1_", 0);
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
