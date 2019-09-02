package com.ardakaplan.rdagoogleplayapps.ui.screens.rdaapps;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;

import com.ardakaplan.rdagoogleplayapps.R;
import com.ardakaplan.rdagoogleplayapps.ui.BaseActivity;
import com.ardakaplan.rdagoogleplayapps.ui.dialogs.TestProgressDialog;
import com.ardakaplan.rdagoogleplayappslib.rdaapps.RDAApplicationsView;
import com.ardakaplan.rdagoogleplayappslib.rdaapps.RDAApplicationsViewHolder;
import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 18-Mar-19 - 10:14
 */
public class RDAAppsActivity extends BaseActivity {

    @Inject
    RDAApplicationsView<RDAApplicationsViewHolder> rdaApplicationsView;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TestProgressDialog testProgressDialog = new TestProgressDialog(this);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);

        //noinspection ConstantConditions
        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider));

        rdaApplicationsView.setItemDecoration(itemDecorator);

        rdaApplicationsView.setItemLayoutId(R.layout.rda_application_view_item);

        rdaApplicationsView.setInstalledAppBackgroundColor(Color.RED);

        rdaApplicationsView.setRdaProgressDialog(testProgressDialog);

        rdaApplicationsView.onViewCreated(findViewById(R.id.rdaAppsActivity_linearLayout_container));
    }

    @Override
    public int getLayout() {
        return R.layout.rda_apps_activity;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }
}
