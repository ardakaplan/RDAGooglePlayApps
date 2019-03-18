package com.ardakaplan.rdagoogleplayappslib;

import com.ardakaplan.rdagoogleplayappslib.rdaapps.RDAApplicationsView;

import dagger.Subcomponent;

/**
 * Created by Arda Kaplan on 18-Mar-19 - 09:52
 */
@Subcomponent(modules = {RDAApplicationsViewModule.class})
public interface AAComponent {

    @Subcomponent.Builder
    public interface Builder {
        AAComponent build();
    }

    void inject(RDAApplicationsView akdView);

}
