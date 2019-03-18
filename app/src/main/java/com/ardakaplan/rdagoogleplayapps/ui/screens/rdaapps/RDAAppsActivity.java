package com.ardakaplan.rdagoogleplayapps.ui.screens.rdaapps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ardakaplan.rdagoogleplayapps.R;
import com.ardakaplan.rdagoogleplayapps.ui.BaseActivity;
import com.ardakaplan.rdagoogleplayappslib.rdaapps.RDAApplicationsView;
import com.ardakaplan.rdagoogleplayappslib.rdaapps.RDAApplicationsViewHolder;

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
        super.onCreate(savedInstanceState, R.layout.rda_apps_activity);

        rdaApplicationsView.onViewCreated(findViewById(R.id.rdaAppsActivity_linearLayout_container));
    }
}
