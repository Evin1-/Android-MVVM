package com.example.app.ui.versions;

import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.example.app.BR;
import com.example.app.data.entities.AndroidVersion;
import com.example.mylibrary.di.ActivityComponent;
import com.example.mylibrary.recycler.ItemViewModel;

/**
 * Created by user on 11/3/17.
 */

public class AndroidVersionItemViewModel extends ItemViewModel<AndroidVersion> {

  private AndroidVersion androidVersion;

  public AndroidVersionItemViewModel(@NonNull ActivityComponent activityComponent) {
    super(activityComponent);
  }

  @Override
  public void setItem(AndroidVersion item) {
    androidVersion = item;
    notifyChange();
  }

  public void onClick() {
    androidVersion.toggleSelected();
    notifyPropertyChanged(BR.selected);
  }

  @Bindable
  public String getVersion() {
    return androidVersion.getVersion();
  }

  @Bindable
  public String getCodeName() {
    return androidVersion.getCodeName();
  }

  @Bindable
  public boolean getSelected() {
    return androidVersion.isSelected();
  }
}