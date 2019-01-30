package com.ardakaplan.rdagoogleplayapps.di;

import com.ardakaplan.rdagoogleplayapps.di.modules.SplashModule;
import com.ardakaplan.rdagoogleplayapps.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {SplashModule.class})
    abstract SplashActivity bindSplashActivity();

}
