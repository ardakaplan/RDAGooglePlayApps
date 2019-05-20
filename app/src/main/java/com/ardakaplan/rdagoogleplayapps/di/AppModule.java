package com.ardakaplan.rdagoogleplayapps.di;

import com.ardakaplan.rdalogger.RDALogger;
import com.ardakaplan.rdaretrofitlib.retrofit.RetrofitSettings;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
class AppModule {


    @Provides
    RetrofitSettings providesRetrofitSettings() {

        HttpLoggingInterceptor.Logger fileLogger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String s) {

                RDALogger.logHttpRequest("TEST HTTP LOG " + s);
            }
        };

        HttpLoggingInterceptor fileLoggerInterceptor = new HttpLoggingInterceptor(fileLogger);
        fileLoggerInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new RetrofitSettings(20,
                "https://www.google.com/",
                HttpLoggingInterceptor.Level.BODY, null, fileLoggerInterceptor);
    }
}
