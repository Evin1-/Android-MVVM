package com.example.app;

import android.content.Intent;

import com.example.app.ui.clicks.ClickCountActivity;
import com.example.app.ui.main.MainActivity;
import com.example.app.ui.main.MainViewModel;
import com.example.app.ui.versions.AndroidVersionsActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by user on 11/7/17.
 */

public class MainViewModelTest extends Assert {

  private MainViewModel viewModel;
  private MainActivity activity;

  @Before
  public void setup() {
    activity = mock(MainActivity.class);
    viewModel = new MainViewModel(getActivityComponent(), null);
  }

  @Test
  public void testOnClickButtonClicks() {
    viewModel.onClickBtnClicks(activity);
    verify(activity).startActivity(new Intent(activity, ClickCountActivity.class));
  }

  @Test
  public void testOnClickButtonRecyclerView() {
    viewModel.onClickBtnRecycler(activity);
    verify(activity).startActivity(new Intent(activity, AndroidVersionsActivity.class));
  }

  @Test
  public void testOnClickHiBrianLee() throws Exception {
    viewModel.onClickHiBrianLee(activity);
    verify(activity).startActivity(Intent.parseUri("https://www.twitter.com/hiBrianLee", 0));
  }
}