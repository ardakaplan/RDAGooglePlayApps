package com.ardakaplan.rdagoogleplayapps.di;

import com.ardakaplan.rdagoogleplayapps.ui.screens.rdaapps.RDAAppsActivity;
import com.ardakaplan.rdagoogleplayapps.ui.screens.splash.SplashActivity;
import com.ardakaplan.rdagoogleplayapps.ui.screens.splash.SplashModule;
import com.ardakaplan.rdagoogleplayappslib.rdaapps.RDAApplicationsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {SplashModule.class})
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = RDAApplicationsModule.class)
    abstract RDAAppsActivity bindRDAAppsActivity();

}
