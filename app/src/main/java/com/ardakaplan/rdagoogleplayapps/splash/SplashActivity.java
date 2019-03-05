package com.ardakaplan.rdagoogleplayapps.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.ardakaplan.rdagoogleplayapps.R;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {


    @BindView(R.id.button_test)
    Button testButton;

    @Inject
    SplashContract.SplashPresenterContract presenter;


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.splash_activity);

        presenter.attach(this);

    }

    @OnClick(R.id.button_test)
    void test() {

        RDALogger.info("TEST");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
