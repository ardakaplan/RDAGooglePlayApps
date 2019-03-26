package com.ardakaplan.rdagoogleplayapps;

import com.ardakaplan.rdagoogleplayapps.di.AppComponent;
import com.ardakaplan.rdagoogleplayapps.di.DaggerAppComponent;
import com.ardakaplan.rdalibrary.base.objects.RDAApplication;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalogger.RDALogger;
import com.ardakaplan.rdaretrofitlib.retrofit.RDARetrofitProvider;

import java.util.ArrayList;
import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Arda Kaplan on 10.08.2018 - 17:44
 */
public class TestApplication extends RDAApplication implements HasCustomActivityInjector {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        RDALogger.start(getString(R.string.app_name)).enableLogging(true);

        initRDARetrofitLib();
    }

    private void initRDARetrofitLib() {
        RDARetrofitProvider.RetrofitManager.TIME_OUT = 20;
        RDARetrofitProvider.RetrofitManager.LOGGING_LEVEL = HttpLoggingInterceptor.Level.BODY;

    }

    @Override
    protected void initDagger() {

        appComponent = DaggerAppComponent.builder().application(this).build();

        appComponent.inject(this);
    }
}
