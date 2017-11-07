package com.example.app.ui.clicks;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.example.app.R;
import com.example.app.databinding.ActivityClickCountBinding;
import com.example.mylibrary.viewmodel.ViewModel;
import com.example.mylibrary.viewmodel.ViewModelActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClickCountActivity extends ViewModelActivity {

  private ClickCountViewModel clickCountViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_click_count);

    ActivityClickCountBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_click_count);
    binding.setViewModel(clickCountViewModel);
    ButterKnife.bind(this);
  }

  @Nullable
  @Override
  protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
    clickCountViewModel = new ClickCountViewModel(this, getActivityComponent(), savedViewModelState);
    return clickCountViewModel;
  }

  @OnClick(R.id.a_click_btn)
  public void onClickButton() {
    clickCountViewModel.onClickButton();
  }
}
