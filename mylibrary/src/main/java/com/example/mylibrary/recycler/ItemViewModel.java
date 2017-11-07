package com.example.mylibrary.recycler;

import android.support.annotation.NonNull;

import com.example.mylibrary.di.ActivityComponent;
import com.example.mylibrary.viewmodel.ViewModel;

/**
 * Created by user on 11/2/17.
 */

public abstract class ItemViewModel<I> extends ViewModel {
  public ItemViewModel(@NonNull ActivityComponent activityComponent) {
    super(activityComponent, null);
  }

  public abstract void setItem(I item);
}