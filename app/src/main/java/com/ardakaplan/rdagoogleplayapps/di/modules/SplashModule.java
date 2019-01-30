package com.ardakaplan.rdagoogleplayapps.di.modules;

import com.ardakaplan.rdagoogleplayapps.splash.SplashContract;
import com.ardakaplan.rdagoogleplayapps.splash.SplashPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SplashModule {

    @Binds
    public abstract SplashContract.SplashPresenterContract providePresenter(SplashPresenter splashPresenter);
}
