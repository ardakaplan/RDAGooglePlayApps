package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import com.ardakaplan.rdagoogleplayappslib.base.BusinessView;
import com.ardakaplan.rdagoogleplayappslib.base.BusinessViewHolder;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RDAApplicationsModule {

    @Binds
    public abstract RDAApplicationsContract.Presenter bindsPresenter(RDAApplicationsPresenter presenter);

    @Binds
    abstract BusinessViewHolder bindDefaultViewHolder(RDAApplicationsViewHolder viewHolder);

    @Binds
    abstract BusinessView<RDAApplicationsViewHolder> bindsView(RDAApplicationsView<RDAApplicationsViewHolder> view);
}