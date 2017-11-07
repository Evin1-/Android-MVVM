package com.example.app.ui.main;

import android.support.annotation.Nullable;

import com.example.app.ui.clicks.ClickCountActivity;
import com.example.app.ui.versions.AndroidVersionsActivity;
import com.example.mylibrary.di.ActivityComponent;
import com.example.mylibrary.viewmodel.ViewModel;

/**
 * Created by user on 11/1/17.
 */

public class MainViewModel extends ViewModel {
  public MainViewModel(ActivityComponent activityComponent, @Nullable State savedInstanceState) {
    super(activityComponent, savedInstanceState);
  }

  public void onClickBtnClicks() {
    attachedActivity.startActivity(ClickCountActivity.class);
  }

  public void onClickBtnRecycler() {
    attachedActivity.startActivity(AndroidVersionsActivity.class);
  }

  public void onClickHiBrianLee() {
    // TODO
    // attachedActivity.openUrl(activity.getString(R.string.twitter_url));
  }
}
