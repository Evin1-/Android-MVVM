package com.example.mylibrary.recycler;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.example.mylibrary.di.ActivityComponent;
import com.example.mylibrary.viewmodel.ViewModel;

/**
 * Created by user on 11/2/17.
 */

public abstract class RecyclerViewViewModel extends ViewModel {

  private RecyclerView.LayoutManager layoutManager;
  private Parcelable savedLayoutManagerState;

  protected abstract RecyclerViewAdapter getAdapter();

  protected abstract RecyclerView.LayoutManager createLayoutManager();

  public RecyclerViewViewModel(ActivityComponent activityComponent, @Nullable State savedInstanceState) {
    super(activityComponent, savedInstanceState);
    if (savedInstanceState instanceof RecyclerViewViewModelState) {
      savedLayoutManagerState =
          ((RecyclerViewViewModelState) savedInstanceState).layoutManagerState;
    }
  }

  @Override
  public RecyclerViewViewModelState getInstanceState() {
    return new RecyclerViewViewModelState(this);
  }

  final void setupRecyclerView(RecyclerView recyclerView) {
    layoutManager = createLayoutManager();
    if (savedLayoutManagerState != null) {
      layoutManager.onRestoreInstanceState(savedLayoutManagerState);
      savedLayoutManagerState = null;
    }
    recyclerView.setAdapter(getAdapter());
    recyclerView.setLayoutManager(layoutManager);
  }

  protected static class RecyclerViewViewModelState extends State {

    private final Parcelable layoutManagerState;

    public RecyclerViewViewModelState(RecyclerViewViewModel viewModel) {
      super(viewModel);
      layoutManagerState = viewModel.layoutManager.onSaveInstanceState();
    }

    public RecyclerViewViewModelState(Parcel in) {
      super(in);
      layoutManagerState = in.readParcelable(
          RecyclerView.LayoutManager.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      super.writeToParcel(dest, flags);
      dest.writeParcelable(layoutManagerState, flags);
    }

    public static Creator<RecyclerViewViewModelState> CREATOR =
        new Creator<RecyclerViewViewModelState>() {
          @Override
          public RecyclerViewViewModelState createFromParcel(Parcel source) {
            return new RecyclerViewViewModelState(source);
          }

          @Override
          public RecyclerViewViewModelState[] newArray(int size) {
            return new RecyclerViewViewModelState[size];
          }
        };
  }
}