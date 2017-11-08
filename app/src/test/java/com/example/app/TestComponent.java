package com.example.app;

import com.example.mylibrary.di.ActivityComponent;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent extends ActivityComponent {

  void inject(BaseTest baseTest);
}