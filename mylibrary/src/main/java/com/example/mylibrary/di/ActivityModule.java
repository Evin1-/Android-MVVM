package com.example.mylibrary.di;

import com.example.mylibrary.attached.AttachedActivity;
import com.example.mylibrary.attached.AttachedViewModelActivity;
import com.example.mylibrary.viewmodel.ViewModelActivity;

import dagger.Module;
import dagger.Provides;

@Module
public final class ActivityModule {

  private final ViewModelActivity activity;

  public ActivityModule(ViewModelActivity activity) {
    this.activity = activity;
  }

  @Provides
  @PerActivity
  AttachedActivity provideAttachedActivity() {
    return new AttachedViewModelActivity(activity);
  }
}