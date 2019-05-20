package com.ardakaplan.rdagoogleplayappslib.service;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdaretrofitlib.RDARequestListener;
import com.ardakaplan.rdaretrofitlib.RDARetrofitCallback;
import com.ardakaplan.rdaretrofitlib.exceptions.RDARequestException;
import com.ardakaplan.rdaretrofitlib.retrofit.RDARetrofitProvider;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 2/20/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public class RDAGooglePlayApplicationsService {

    private final String BASE_URL = "http://www.ardakaplan.com";

    private final String APP_URL = BASE_URL + "/rdaapps/rda_apps.txt";

    private RDARetrofitProvider rdaRetrofitProvider;

    @Inject
    RDAGooglePlayApplicationsService(RDARetrofitProvider rdaRetrofitProvider) {
        this.rdaRetrofitProvider = rdaRetrofitProvider;
    }

    public void getRDAGooglePlayApplications(RDARequestListener<List<RDAGooglePlayApplication>> requestListener) {

        rdaRetrofitProvider.makeRequest(rdaRetrofitProvider.createRetrofit(RDAGooglePlayApplicationsServiceRetrofitInterface.class)
                .getRDAApplications(APP_URL), new RDARetrofitCallback<List<RDAGooglePlayApplication>>() {

            @Override
            public void onSuccess(List<RDAGooglePlayApplication> googlePlayApplications) {

                requestListener.onSuccess(googlePlayApplications);
            }

            @Override
            public void onError(RDARequestException e) {

                requestListener.onError(e);

                e.printStackTrace();
            }
        });
    }
}
