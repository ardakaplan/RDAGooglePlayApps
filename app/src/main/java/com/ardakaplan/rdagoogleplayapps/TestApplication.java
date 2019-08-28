package com.ardakaplan.rdagoogleplayapps;

import com.ardakaplan.rdagoogleplayapps.di.AppComponent;
import com.ardakaplan.rdagoogleplayapps.di.DaggerAppComponent;
import com.ardakaplan.rdalibrary.base.objects.RDAApplication;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdaretrofitlib.retrofit.RDARetrofitProvider;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Arda Kaplan on 10.08.2018 - 17:44
 */
public class TestApplication extends RDAApplication implements HasCustomActivityInjector {

    @Override
    public void onCreate() {
        super.onCreate();

        initRDARetrofitLib();
    }

    @Override
    protected String getRDALoggerTag() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean doesRDALoggerWork() {
        return true;
    }

    private void initRDARetrofitLib() {
        RDARetrofitProvider.RetrofitManager.TIME_OUT = 20;
        RDARetrofitProvider.RetrofitManager.LOGGING_LEVEL = HttpLoggingInterceptor.Level.BODY;

    }

    @Override
    protected void initDagger() {

        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();

        appComponent.inject(this);
    }

    @Override
    protected void initRDADialog() {

    }
}
