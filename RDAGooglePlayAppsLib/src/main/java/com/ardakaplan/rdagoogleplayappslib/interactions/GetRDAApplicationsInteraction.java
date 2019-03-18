package com.ardakaplan.rdagoogleplayappslib.interactions;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteraction;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResult;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResultListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 15-Mar-19 - 19:55
 */
public class GetRDAApplicationsInteraction extends RDAInteraction<RDAInteractionResult.Empty, List<RDAGooglePlayApplication>> {


    @Inject
    GetRDAApplicationsInteraction() {

    }

    @Override
    public void execute(RDAInteractionResultListener<List<RDAGooglePlayApplication>> rdaInteractionResultListener) {


        rdaInteractionResultListener.onResult(new RDAInteractionResult<>(getApplicationsFromLocal()));
    }

    private ArrayList<RDAGooglePlayApplication> getApplicationsFromLocal() {

        ArrayList<RDAGooglePlayApplication> rdaGooglePlayApplications = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            RDAGooglePlayApplication rdaGooglePlayApplication = new RDAGooglePlayApplication();

            rdaGooglePlayApplication.setNameTurkish("TURKÇE " + i);
            rdaGooglePlayApplication.setNameTurkish("ENGLISH  " + i);
            rdaGooglePlayApplication.setDescriptionTurkish("açıklama " + i);
            rdaGooglePlayApplication.setDescriptionTurkish("desc " + i);

            rdaGooglePlayApplications.add(rdaGooglePlayApplication);
        }

        return rdaGooglePlayApplications;
    }
}

