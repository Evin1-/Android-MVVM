package com.example.app.ui.versions;


import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.R;
import com.example.app.data.entities.AndroidVersion;
import com.example.app.databinding.ItemAndroidVersionBinding;
import com.example.mylibrary.recycler.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 11/3/17.
 */

public class AndroidVersionsAdapter extends RecyclerViewAdapter<AndroidVersion, AndroidVersionItemViewModel> {

  @Override
  public AndroidVersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_android_version, parent, false);

    AndroidVersionItemViewModel viewModel = new AndroidVersionItemViewModel();

    ItemAndroidVersionBinding binding = ItemAndroidVersionBinding.bind(itemView);
    binding.setViewModel(viewModel);

    return new AndroidVersionViewHolder(itemView, binding, viewModel);
  }

  public void setItems(ArrayList<AndroidVersion> newItems) {
    items.clear();
    items.addAll(newItems);
    notifyDataSetChanged();
  }

  public ArrayList<AndroidVersion> getItems() {
    return items;
  }

  static class AndroidVersionViewHolder extends RecyclerViewAdapter.ItemViewHolder<AndroidVersion, AndroidVersionItemViewModel> {

    public AndroidVersionViewHolder(View itemView, ViewDataBinding binding, AndroidVersionItemViewModel viewModel) {
      super(itemView, binding, viewModel);
      ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.versionItem)
    void onClickVersionItem() {
      viewModel.onClick();
    }
  }
}