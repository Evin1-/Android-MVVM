package com.example.app.ui.versions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.app.R;
import com.example.mylibrary.viewmodel.ViewModelActivity;

public class AndroidVersionsActivity extends ViewModelActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_android_versions);
  }
}
