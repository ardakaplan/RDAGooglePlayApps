package com.ardakaplan.rdagoogleplayapps.ui.screens.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ardakaplan.rdagoogleplayapps.R;
import com.ardakaplan.rdagoogleplayapps.ui.screens.rdaapps.RDAAppsActivity;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalibrary.helpers.RDAIntentHelpers;

import javax.inject.Inject;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @Inject
    RDAIntentHelpers rdaIntentHelpers;


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.splash_activity);

        presenter.attach(this);

        startActivity(rdaIntentHelpers.getClearCacheIntent(RDAAppsActivity.class));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
