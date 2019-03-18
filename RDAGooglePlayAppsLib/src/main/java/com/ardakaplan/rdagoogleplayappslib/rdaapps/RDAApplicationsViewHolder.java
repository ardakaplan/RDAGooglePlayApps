package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ardakaplan.rdagoogleplayappslib.R;
import com.ardakaplan.rdagoogleplayappslib.base.BusinessViewHolder;

import javax.inject.Inject;

public class RDAApplicationsViewHolder extends BusinessViewHolder {

    private RecyclerView recyclerView;

    @Inject
    RDAApplicationsViewHolder() {

    }

    @Override
    public void findViews(View view) {

        recyclerView = view.findViewById(getRecyclerViewId());
    }

    protected @IdRes
    int getRecyclerViewId() {

        return R.id.rdaApplicationView_recyclerView;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
