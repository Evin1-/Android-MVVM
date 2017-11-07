package com.example.mylibrary.attached;

import android.app.Activity;
import android.content.Intent;

import com.example.mylibrary.viewmodel.ViewModelActivity;

import java.lang.ref.WeakReference;
import java.net.URISyntaxException;

public final class AttachedViewModelActivity implements AttachedActivity {

  private final WeakReference<ViewModelActivity> weakActivity;

  public AttachedViewModelActivity(ViewModelActivity activity) {
    weakActivity = new WeakReference<>(activity);
  }

  @Override
  public void startActivity(Class<? extends Activity> activityClass) {
    ViewModelActivity activity = weakActivity.get();
    if (activity != null && !activity.isFinishing()) {
      activity.startActivity(new Intent(activity, activityClass));
    }
  }

  @Override
  public void openUrl(String url) throws URISyntaxException {
    ViewModelActivity activity = weakActivity.get();
    if (activity != null && !activity.isFinishing()) {
      activity.startActivity(Intent.parseUri(url, 0));
    }
  }
}