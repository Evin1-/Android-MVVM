package com.example.app;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mylibrary.ViewModel;
import com.example.mylibrary.ViewModelActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ViewModelActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Nullable
    @Override
    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
        viewModel = new MainViewModel(savedViewModelState);
        return viewModel;
    }

    @OnClick(R.id.a_main_btn_clicks)
    public void onClickBtnClicks() {
        viewModel.onClickBtnClicks(this);
    }

    @OnClick(R.id.a_main_btn_recycler)
    public void onClickBtnRecycler() {
        viewModel.onClickBtnRecycler(this);
    }
}
