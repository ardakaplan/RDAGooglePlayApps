package com.ardakaplan.rdagoogleplayappslib.tradeMenu;

import com.ardakaplan.rdagoogleplayappslib.R;
import com.ardakaplan.rdagoogleplayappslib.base.BusinessView;

import javax.inject.Inject;

public class TradeMenuBusinessView<VH extends TradeMenuViewHolder> extends BusinessView<VH> implements TradeMenuContract.View {

    private TradeMenuContract.Presenter presenter;

    @Inject
    public TradeMenuBusinessView(VH viewHolder, TradeMenuContract.Presenter presenter) {
        super(viewHolder);
        this.presenter = presenter;

    }

    @Override
    protected int getLayout() {
        return R.layout.trade_menu_view;
    }

    @Override
    public void onViewHolderCreated(VH vh) {

    }

    /**
     * ekran her ön yüze geldiğinde login olma kontrollerini yapar,
     */
    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onViewDestroyed() {
        super.onViewDestroyed();
        presenter.detach();
    }
}
