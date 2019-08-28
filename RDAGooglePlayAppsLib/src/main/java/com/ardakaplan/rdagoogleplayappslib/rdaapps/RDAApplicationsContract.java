package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAViewContract;

import java.util.List;

public class RDAApplicationsContract {

    public interface View extends RDAViewContract {

        void showProgress();

        void hideProgress();

        void showRDAGooglePlayApplications(List<RDAGooglePlayApplication> rdaGooglePlayApplications);
    }

    public interface Presenter extends RDAPresenterContract<View> {


    }
}
