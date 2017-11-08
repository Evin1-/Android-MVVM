package com.example.app;

import android.support.annotation.CallSuper;

import com.example.mylibrary.attached.AttachedActivity;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;

import javax.inject.Inject;

public abstract class BaseTest extends Assert {

  protected final TestComponent testComponent;

  @Inject
  protected AttachedActivity attachedActivity;

  public BaseTest() {
    testComponent = DaggerTestComponent.builder()
        .testModule(new TestModule())
        .build();
    testComponent.inject(this);
  }

  @CallSuper
  @Before
  public void setup() {
    Mockito.reset(attachedActivity);
  }
}