package com.ardakaplan.rdagoogleplayappslib.service;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Arda Kaplan at 3/25/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public interface RDAGooglePlayApplicationsServiceRetrofitInterface {

    @GET
    Call<List<RDAGooglePlayApplication>> getRDAApplications(@Url String url);
}
