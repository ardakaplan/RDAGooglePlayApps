package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

import com.ardakaplan.rdagoogleplayappslib.R;
import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdagoogleplayappslib.base.BusinessView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 15-Mar-19 - 19:53
 */
public class RDAApplicationsView<VH extends RDAApplicationsViewHolder> extends BusinessView<VH> implements RDAApplicationsContract.View {

    private RDAApplicationsContract.Presenter presenter;
    private RDAApplicationsRecyclerViewAdapter rdaApplicationsRecyclerViewAdapter;

    private RecyclerView.ItemDecoration itemDecoration;

    private @LayoutRes
    int itemLayoutId;

    @Inject
    public RDAApplicationsView(VH viewHolder, RDAApplicationsContract.Presenter presenter, RDAApplicationsRecyclerViewAdapter rdaApplicationsRecyclerViewAdapter) {
        super(viewHolder);
        this.presenter = presenter;
        this.rdaApplicationsRecyclerViewAdapter = rdaApplicationsRecyclerViewAdapter;

    }

    @Override
    protected int getLayout() {
        return R.layout.rda_application_view_lib;
    }

    @Override
    public void onViewHolderCreated(VH viewHolder) {

        setRecyclerView();

        presenter.attach(this);
    }

    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    public void setItemLayoutId(int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
    }

    private void setRecyclerView() {

        if (itemDecoration != null) {

            getViewHolder().getRecyclerView().addItemDecoration(itemDecoration);
        }

        getViewHolder().getRecyclerView().setAdapter(rdaApplicationsRecyclerViewAdapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showRDAGooglePlayApplications(List<RDAGooglePlayApplication> rdaGooglePlayApplications) {

        rdaApplicationsRecyclerViewAdapter.setData(rdaGooglePlayApplications);
    }

    @Override
    public void onViewDestroyed() {
        super.onViewDestroyed();
        presenter.detach();
    }
}
