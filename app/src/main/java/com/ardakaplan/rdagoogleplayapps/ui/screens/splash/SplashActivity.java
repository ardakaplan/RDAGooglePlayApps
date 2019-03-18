package com.ardakaplan.rdagoogleplayapps.ui.screens.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ardakaplan.rdagoogleplayapps.R;
import com.ardakaplan.rdagoogleplayappslib.tradeMenu.TradeMenuBusinessView;
import com.ardakaplan.rdagoogleplayappslib.tradeMenu.TradeMenuViewHolder;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;

import javax.inject.Inject;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @Inject
    TradeMenuBusinessView<TradeMenuViewHolder> tradeMenuBusinessView;


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.splash_activity);

        presenter.attach(this);

        tradeMenuBusinessView.onViewCreated(findViewById(R.id.aaaa));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
