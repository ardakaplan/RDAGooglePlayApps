package com.ardakaplan.rdagoogleplayappslib.rdaapps;

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

    @Inject
    public RDAApplicationsView(VH viewHolder, RDAApplicationsContract.Presenter presenter, RDAApplicationsRecyclerViewAdapter rdaApplicationsRecyclerViewAdapter) {
        super(viewHolder);
        this.presenter = presenter;
        this.rdaApplicationsRecyclerViewAdapter = rdaApplicationsRecyclerViewAdapter;

    }

    @Override
    protected int getLayout() {
        return R.layout.rda_application_view;
    }

    @Override
    public void onViewHolderCreated(VH viewHolder) {

        setRecyclerView();

        presenter.attach(this);
    }

    private void setRecyclerView() {

        getViewHolder().getRecyclerView().setAdapter(rdaApplicationsRecyclerViewAdapter);
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
