package com.ardakaplan.rdagoogleplayappslib.interactions;

import android.content.Context;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteraction;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResult;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResultListener;
import com.ardakaplan.rdalibrary.helpers.RDAJsonHelpers;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 15-Mar-19 - 19:55
 */
public class GetRDAApplicationsInteraction extends RDAInteraction<RDAInteractionResult.Empty, List<RDAGooglePlayApplication>> {

    private Context context;

    @Inject
    GetRDAApplicationsInteraction(Context context) {

        this.context = context;
    }

    @Override
    public void execute(RDAInteractionResultListener<List<RDAGooglePlayApplication>> rdaInteractionResultListener) {

        String source = loadAppsFromLocale();

        Type collectionType = new TypeToken<List<RDAGooglePlayApplication>>() {
        }.getType();

        ArrayList<RDAGooglePlayApplication> objects = (ArrayList<RDAGooglePlayApplication>) RDAJsonHelpers.jsonToList(source, collectionType);


        rdaInteractionResultListener.onResult(new RDAInteractionResult<>(objects));
    }

    public String loadAppsFromLocale() {
        String tContents = "";

        try {
            InputStream stream = context.getAssets().open("apps.json");

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return tContents;

    }


}

