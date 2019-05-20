package com.ardakaplan.rdagoogleplayappslib.interactions;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdagoogleplayappslib.service.RDAGooglePlayApplicationsService;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteraction;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResult;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResultListener;
import com.ardakaplan.rdaretrofitlib.RDARequestListener;
import com.ardakaplan.rdaretrofitlib.RequestErrorConverter;
import com.ardakaplan.rdaretrofitlib.exceptions.RDARequestException;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 15-Mar-19 - 19:55
 */
public class GetRDAApplicationsInteraction extends RDAInteraction<RDAInteractionResult.Empty, List<RDAGooglePlayApplication>> {

    private RDAGooglePlayApplicationsService rdaGooglePlayApplicationsService;


    @Inject
    GetRDAApplicationsInteraction(RDAGooglePlayApplicationsService rdaGooglePlayApplicationsService) {

        this.rdaGooglePlayApplicationsService = rdaGooglePlayApplicationsService;
    }

    @Override
    public void execute(RDAInteractionResultListener<List<RDAGooglePlayApplication>> rdaInteractionResultListener) {

//        String source = loadAppsFromLocale();
//
//        Type collectionType = new TypeToken<List<RDAGooglePlayApplication>>() {
//        }.getType();
//
//        ArrayList<RDAGooglePlayApplication> objects = (ArrayList<RDAGooglePlayApplication>) RDAJsonHelpers.jsonToList(source, collectionType);
//
//
//        rdaInteractionResultListener.onResult(new RDAInteractionResult<>(objects));

        rdaGooglePlayApplicationsService.getRDAGooglePlayApplications(new RDARequestListener<List<RDAGooglePlayApplication>>() {

            @Override
            public void onSuccess(List<RDAGooglePlayApplication> googlePlayApplications) {

                rdaInteractionResultListener.onResult(new RDAInteractionResult<>(googlePlayApplications));
            }

            @Override
            public void onError(RDARequestException rdaRequestException) {

                rdaInteractionResultListener.onResult(new RDAInteractionResult<>(RequestErrorConverter.convertExceptions(rdaRequestException)));
            }
        });
    }

//    public String loadAppsFromLocale() {
//        String tContents = "";
//
//        try {
//            InputStream stream = context.getAssets().open("apps.json");
//
//            int size = stream.available();
//            byte[] buffer = new byte[size];
//            stream.read(buffer);
//            stream.close();
//            tContents = new String(buffer);
//        } catch (IOException e) {
//            // Handle exceptions here
//        }
//
//        return tContents;
//
//    }


}

