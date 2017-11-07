package com.example.mylibrary.di;

import com.example.mylibrary.viewmodel.ViewModel;

import dagger.Component;

@PerActivity
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

  void inject(ViewModel viewModel);
}