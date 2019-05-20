package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import com.ardakaplan.rdalibrary.base.ui.views.custom.RDAView;
import com.ardakaplan.rdalibrary.base.ui.views.custom.RDAViewHolder;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RDAApplicationsModule {

    @Binds
    public abstract RDAApplicationsContract.Presenter bindsPresenter(RDAApplicationsPresenter presenter);

    @Binds
    abstract RDAViewHolder bindDefaultViewHolder(RDAApplicationsViewHolder viewHolder);

    @Binds
    abstract RDAView<RDAApplicationsViewHolder> bindsView(RDAApplicationsView<RDAApplicationsViewHolder> view);
}