package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdagoogleplayappslib.interactions.GetRDAApplicationsInteraction;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResult;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResultListener;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAPresenter;

import java.util.List;

import javax.inject.Inject;

public class RDAApplicationsPresenter extends RDAPresenter<RDAApplicationsContract.View> implements RDAApplicationsContract.Presenter {

    private GetRDAApplicationsInteraction getRDAApplicationsInteraction;

    @Inject
    RDAApplicationsPresenter(GetRDAApplicationsInteraction getRDAApplicationsInteraction) {
        this.getRDAApplicationsInteraction = getRDAApplicationsInteraction;
    }

    @Override
    protected void onAttached() {

        getApplications();
    }

    @Override
    protected void onDetached() {

    }

    private void getApplications() {

        if (gettView() != null) {

            gettView().showProgress();
        }

        getRDAApplicationsInteraction.execute(new RDAInteractionResultListener<List<RDAGooglePlayApplication>>() {

            @Override
            public void onResult(RDAInteractionResult<List<RDAGooglePlayApplication>> rdaInteractionResult) {

                if (gettView() != null) {

                    gettView().hideProgress();

                    gettView().showRDAGooglePlayApplications(rdaInteractionResult.getOut());
                }
            }
        });
    }
}
