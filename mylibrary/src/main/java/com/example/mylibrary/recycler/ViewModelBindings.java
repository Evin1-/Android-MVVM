package com.example.mylibrary.recycler;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by user on 11/2/17.
 */

public class ViewModelBindings {
  @BindingAdapter("recyclerViewViewModel")
  public static void setRecyclerViewViewModel(RecyclerView recyclerView,
                                              RecyclerViewViewModel viewModel) {
    viewModel.setupRecyclerView(recyclerView);
  }
}
