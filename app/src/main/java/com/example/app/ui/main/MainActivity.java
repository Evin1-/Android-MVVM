package com.example.app.ui.main;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.example.app.R;
import com.example.mylibrary.viewmodel.ViewModel;
import com.example.mylibrary.viewmodel.ViewModelActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ViewModelActivity {

  private MainViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
  }

  @Nullable
  @Override
  protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
    viewModel = new MainViewModel(getActivityComponent(), savedViewModelState);
    return viewModel;
  }

  @OnClick(R.id.a_main_btn_clicks)
  public void onClickBtnClicks() {
    viewModel.onClickBtnClicks();
  }

  @OnClick(R.id.a_main_btn_recycler)
  public void onClickBtnRecycler() {
    viewModel.onClickBtnRecycler();
  }
}
