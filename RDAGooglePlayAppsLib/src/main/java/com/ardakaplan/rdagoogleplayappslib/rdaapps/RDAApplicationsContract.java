package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import com.ardakaplan.rdalibrary.base.ui.screen.RDAPresenterContract;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAViewContract;

public class RDAApplicationsContract {

    public interface View extends RDAViewContract {

    }

    public interface Presenter extends RDAPresenterContract<View> {


    }
}
