package com.example.app.ui.versions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.R;
import com.example.app.databinding.FragmentAndroidVersionsBinding;
import com.example.mylibrary.di.ActivityComponent;
import com.example.mylibrary.viewmodel.ViewModel;
import com.example.mylibrary.viewmodel.ViewModelFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 11/7/17.
 */

public class AndroidVersionsFragment extends ViewModelFragment {

  private AndroidVersionsViewModel androidVersionsViewModel;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_android_versions, container, false);
    ButterKnife.bind(this, root);
    return root;
  }

//  @Nullable
//  @Override
//  protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
//    androidVersionsViewModel = new AndroidVersionsViewModel(getContext(), savedViewModelState);
//    return androidVersionsViewModel;
//  }

  @Nullable
  @Override
  protected ViewModel createAndBindViewModel(View root,
                                             @NonNull ActivityComponent activityComponent,
                                             @Nullable ViewModel.State savedViewModelState) {
    androidVersionsViewModel = new AndroidVersionsViewModel(getContext(), activityComponent,
        savedViewModelState);
    FragmentAndroidVersionsBinding binding = FragmentAndroidVersionsBinding.bind(root);
    binding.setViewModel(androidVersionsViewModel);
    return androidVersionsViewModel;
  }

  @OnClick(R.id.hiBrianLee)
  void onClickHiBrianLee() {
    androidVersionsViewModel.onClickHiBrianLee(getActivity());
  }
}
