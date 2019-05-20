package com.ardakaplan.rdagoogleplayapps.ui.screens.splash;

import com.ardakaplan.rdagoogleplayapps.ui.screens.splash.SplashContract;
import com.ardakaplan.rdagoogleplayapps.ui.screens.splash.SplashPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SplashModule {

    @Binds
    public abstract SplashContract.SplashPresenterContract providePresenter(SplashPresenter splashPresenter);
}
