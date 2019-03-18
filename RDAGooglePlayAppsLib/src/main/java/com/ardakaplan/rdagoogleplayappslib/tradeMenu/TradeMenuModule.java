package com.ardakaplan.rdagoogleplayappslib.tradeMenu;

import com.ardakaplan.rdagoogleplayappslib.base.BusinessView;
import com.ardakaplan.rdagoogleplayappslib.base.BusinessViewHolder;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TradeMenuModule {

    @Binds
    public abstract TradeMenuContract.Presenter bindsPresenter(TradeMenuPresenter tradeMenuPresenter);

    @Binds
    abstract BusinessViewHolder bindDefaultViewHolder(TradeMenuViewHolder tradeMenuViewHolder);

    @Binds
    abstract BusinessView<TradeMenuViewHolder> bindsView(TradeMenuBusinessView<TradeMenuViewHolder> tradeMenuBusinessView);
}