package com.example.mylibrary.viewmodel;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mylibrary.di.ActivityComponent;
import com.example.mylibrary.di.ActivityModule;
import com.example.mylibrary.di.DaggerActivityComponent;

/**
 * Created by user on 11/1/17.
 */

public abstract class ViewModelActivity extends AppCompatActivity {

  private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

  private ViewModel viewModel;

  private ActivityComponent activityComponent;

  @Nullable
  protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
    return null;
  }

  @CallSuper
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    activityComponent = DaggerActivityComponent.builder()
        .activityModule(new ActivityModule(this))
        .build();

    ViewModel.State savedViewModelState = null;
    if (savedInstanceState != null) {
      savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
    }
    viewModel = createViewModel(savedViewModelState);
  }

  @CallSuper
  @Override
  protected void onStart() {
    super.onStart();
    if (viewModel != null) {
      viewModel.onStart();
    }
  }

  @CallSuper
  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (viewModel != null) {
      outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
    }
  }

  @CallSuper
  @Override
  protected void onStop() {
    super.onStop();
    if (viewModel != null) {
      viewModel.onStop();
    }
  }

  public final ActivityComponent getActivityComponent() {
    return activityComponent;
  }
}