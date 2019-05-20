package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

import com.ardakaplan.rdagoogleplayappslib.R;
import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdalibrary.base.ui.dialogs.RDAProgressDialog;
import com.ardakaplan.rdalibrary.base.ui.views.custom.RDAView;
import com.ardakaplan.rdalibrary.helpers.RDAApplicationHelpers;
import com.ardakaplan.rdalibrary.helpers.RDAIntentHelpers;
import com.ardakaplan.rdalibrary.interfaces.RDAItemClickListener;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 15-Mar-19 - 19:53
 */
public class RDAApplicationsView<VH extends RDAApplicationsViewHolder> extends RDAView<VH> implements RDAApplicationsContract.View, RDAItemClickListener<RDAGooglePlayApplication> {

    private RDAApplicationsContract.Presenter presenter;
    private RDAApplicationsRecyclerViewAdapter rdaApplicationsRecyclerViewAdapter;
    private RDAApplicationHelpers rdaApplicationHelpers;
    private RDAIntentHelpers rdaIntentHelpers;

    //uygulama tarafından set edilecek alanlar
    private RecyclerView.ItemDecoration itemDecoration;
    private @LayoutRes
    Integer itemLayoutId;
    private @ColorInt
    int installedAppBackgroundColor;
    private RDAProgressDialog rdaProgressDialog;

    @Inject
    public RDAApplicationsView(VH viewHolder, RDAApplicationsContract.Presenter presenter, RDAApplicationsRecyclerViewAdapter rdaApplicationsRecyclerViewAdapter,
                               RDAApplicationHelpers rdaApplicationHelpers, RDAIntentHelpers rdaIntentHelpers) {
        super(viewHolder);
        this.presenter = presenter;
        this.rdaApplicationsRecyclerViewAdapter = rdaApplicationsRecyclerViewAdapter;
        this.rdaApplicationHelpers = rdaApplicationHelpers;
        this.rdaIntentHelpers = rdaIntentHelpers;
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

    public void setRdaProgressDialog(RDAProgressDialog rdaProgressDialog) {
        this.rdaProgressDialog = rdaProgressDialog;
    }

    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    public void setInstalledAppBackgroundColor(@ColorInt int installedAppBackgroundColor) {
        this.installedAppBackgroundColor = installedAppBackgroundColor;
    }

    public void setItemLayoutId(Integer itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
    }

    private void setRecyclerView() {

        if (itemDecoration != null) {

            getViewHolder().getRecyclerView().addItemDecoration(itemDecoration);
        }

        if (itemLayoutId != null) {

            rdaApplicationsRecyclerViewAdapter.setItemLayoutId(itemLayoutId);
        }

        rdaApplicationsRecyclerViewAdapter.setInstalledAppBackgroundColor(installedAppBackgroundColor);

        rdaApplicationsRecyclerViewAdapter.setRdaItemClickListener(this);

        getViewHolder().getRecyclerView().setAdapter(rdaApplicationsRecyclerViewAdapter);
    }

    @Override
    public void showProgress() {

        if (rdaProgressDialog != null) {

            rdaProgressDialog.show();
        }
    }

    @Override
    public void hideProgress() {

        if (rdaProgressDialog != null) {

            rdaProgressDialog.dismiss();
        }
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

    @Override
    public void onItemClick(RDAGooglePlayApplication rdaGooglePlayApplication) {

        if (rdaApplicationHelpers.isApplicationInstalled(rdaGooglePlayApplication.getPackageName())) {

            rdaIntentHelpers.openApplication(rdaGooglePlayApplication.getPackageName());

        } else {

            rdaIntentHelpers.openGooglePlayPage(rdaGooglePlayApplication.getPackageName());
        }
    }
}
