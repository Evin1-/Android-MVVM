package com.example.mylibrary.recycler;

import com.example.mylibrary.viewmodel.ViewModel;

/**
 * Created by user on 11/2/17.
 */

public abstract class ItemViewModel<I> extends ViewModel {
  public ItemViewModel() {
    super(null);
  }

  public abstract void setItem(I item);
}