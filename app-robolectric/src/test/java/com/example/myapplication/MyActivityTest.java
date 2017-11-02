package com.example.myapplication;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 11/1/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MyActivityTest {

    @BindView(R.id.a_main_btn)
    Button button;

    @BindView(R.id.a_main_txt)
    TextView textView;

    @BindView(R.id.a_main_progress)
    ProgressBar progressBar;

    @BindView(R.id.a_main_list)
    ListView listView;

    private MainActivity activity;
    private Unbinder unbinder;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
        unbinder = ButterKnife.bind(this, activity);
    }

    @After
    public void tearDown() throws Exception {
        activity = null;
        unbinder.unbind();
    }

    @Test
    public void showError_shouldShowToast() throws Exception {
        String error = "Be careful!";

        activity.showError(error);

        assertThat(ShadowToast.getTextOfLatestToast(), equalTo(error));
    }

    @Test
    public void showProgress_progressBarShouldBeVisible() throws Exception {
        activity.showProgress();

        assertThat(progressBar.getVisibility(), equalTo(View.VISIBLE));
    }

    @Test
    public void hideProgress_progressBarShouldBeGone() throws Exception {
        activity.showProgress();

        activity.hideProgress();

        assertThat(progressBar.getVisibility(), equalTo(View.GONE));
    }

    @Test
    public void showResults_mockData_listViewShouldContainData() throws Exception {
        List<String> results = Arrays.asList("Hello", "World", "Friends");

        activity.showResults(results);

        assertThat(listView.getAdapter().getCount(), equalTo(3));
        assertThat(listView.getAdapter().getItem(1), equalTo("World"));
    }

    @Test
    public void showResults_realData_listViewShouldContainData() throws Exception {
        button.performClick();

        assertThat(listView.getAdapter().getCount(), equalTo(5));
    }
}