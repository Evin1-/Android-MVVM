package com.example.mylibrary.viewmodel;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.mylibrary.attached.AttachedActivity;
import com.example.mylibrary.di.ActivityComponent;

import javax.inject.Inject;

/**
 * Created by user on 11/1/17.
 */

public abstract class ViewModel extends BaseObservable {

  @Inject
  protected AttachedActivity attachedActivity;

  protected ViewModel(@NonNull ActivityComponent activityComponent,
                      @Nullable State savedInstanceState) {
    activityComponent.inject(this);
  }

  @CallSuper
  public void onStart() {

  }

  public State getInstanceState() {
    return new State(this);
  }

  @CallSuper
  public void onStop() {

  }

  public static class State implements Parcelable {

    protected State(ViewModel viewModel) {

    }

    public State(Parcel in) {

    }

    @Override
    public int describeContents() {
      return 0;
    }

    @CallSuper
    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static Creator<State> CREATOR = new Creator<State>() {
      @Override
      public State createFromParcel(Parcel source) {
        return new State(source);
      }

      @Override
      public State[] newArray(int size) {
        return new State[size];
      }
    };
  }
}
