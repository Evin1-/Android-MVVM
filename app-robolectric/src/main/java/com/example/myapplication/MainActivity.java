package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.a_main_btn)
    Button button;

    @BindView(R.id.a_main_txt)
    TextView textView;

    @BindView(R.id.a_main_progress)
    ProgressBar progressBar;

    @BindView(R.id.a_main_list)
    ListView listView;

    private MainPresenter mainPresenter;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter();

        ButterKnife.bind(this);

        button.setOnClickListener(v -> mainPresenter.loadResults());

        strings = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainPresenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mainPresenter.detachView();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showResults(List<String> results) {
        strings.clear();
        strings.addAll(results);
        arrayAdapter.notifyDataSetChanged();
    }
}
