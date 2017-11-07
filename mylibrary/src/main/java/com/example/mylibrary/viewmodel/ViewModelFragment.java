package com.example.mylibrary.viewmodel;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.mylibrary.di.ActivityComponent;

/**
 * Created by user on 11/1/17.
 */

public abstract class ViewModelFragment extends Fragment {

  private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

  private ViewModel viewModel;

  @Nullable
  protected abstract ViewModel createAndBindViewModel(View root,
                                                      @NonNull ActivityComponent activityComponent,
                                                      @Nullable ViewModel.State savedViewModelState);

  @CallSuper
  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    ViewModel.State savedViewModelState = null;
    if (savedInstanceState != null) {
      savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
    }
    ViewModelActivity activity = (ViewModelActivity) getActivity();
    viewModel = createAndBindViewModel(getView(), activity.getActivityComponent(),
        savedViewModelState);
  }

  @CallSuper
  @Override
  public void onStart() {
    super.onStart();
    if (viewModel != null) {
      viewModel.onStart();
    }
  }

  @CallSuper
  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (viewModel != null) {
      outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
    }
  }

  @CallSuper
  @Override
  public void onStop() {
    super.onStop();
    if (viewModel != null) {
      viewModel.onStop();
    }
  }
}