package com.example.app;

import com.example.mylibrary.attached.AttachedActivity;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class TestModule {

  @Provides
  @Singleton
  AttachedActivity provideAttachedActivity() {
    return Mockito.mock(AttachedActivity.class);
  }
}