package com.example.app;

import com.example.app.ui.clicks.ClickCountActivity;
import com.example.app.ui.main.MainViewModel;
import com.example.app.ui.versions.AndroidVersionsActivity;

import org.junit.Test;

import static org.mockito.Mockito.verify;

/**
 * Created by user on 11/7/17.
 */

public class MainViewModelTest extends BaseTest {

  private MainViewModel viewModel;

  @Override
  public void setup() {
    super.setup();
    viewModel = new MainViewModel(testComponent, null);
  }

  @Test
  public void testOnClickButtonClicks() {
    viewModel.onClickBtnClicks();
    verify(attachedActivity).startActivity(ClickCountActivity.class);
  }

  @Test
  public void testOnClickButtonRecyclerView() {
    viewModel.onClickBtnRecycler();
    verify(attachedActivity).startActivity(AndroidVersionsActivity.class);
  }

  @Test
  public void testOnClickHiBrianLee() throws Exception {
    // TODO
  }
}