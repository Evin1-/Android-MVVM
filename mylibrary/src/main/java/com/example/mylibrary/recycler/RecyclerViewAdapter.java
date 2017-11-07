package com.example.mylibrary.recycler;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mylibrary.di.ActivityComponent;

import java.util.ArrayList;

/**
 * Created by user on 11/2/17.
 */

public abstract class RecyclerViewAdapter<ITEM_T, VIEW_MODEL_T extends ItemViewModel<ITEM_T>>
    extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder<ITEM_T, VIEW_MODEL_T>> {

  protected final ArrayList<ITEM_T> items;
  private final ActivityComponent activityComponent;

  public RecyclerViewAdapter(@NonNull ActivityComponent activityComponent) {
    this.activityComponent = activityComponent;
    items = new ArrayList<>();
  }

  public ActivityComponent getActivityComponent() {
    return activityComponent;
  }

  @Override
  public final void onBindViewHolder(ItemViewHolder<ITEM_T, VIEW_MODEL_T> holder, int position) {
    holder.setItem(items.get(position));
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public static class ItemViewHolder<T, VH extends ItemViewModel<T>>
      extends RecyclerView.ViewHolder {

    protected final VH viewModel;
    private final ViewDataBinding binding;

    public ItemViewHolder(View itemView, ViewDataBinding binding, VH viewModel) {
      super(itemView);
      this.binding = binding;
      this.viewModel = viewModel;
    }

    void setItem(T item) {
      viewModel.setItem(item);
      binding.executePendingBindings();
    }
  }
}