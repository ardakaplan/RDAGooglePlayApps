package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ardakaplan.rdagoogleplayappslib.R;
import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdalibrary.base.ui.adapters.RDARecyclerViewAdapter;
import com.ardakaplan.rdalibrary.base.ui.views.fontables.RDATextView;

import javax.inject.Inject;

public class RDAApplicationsRecyclerViewAdapter extends RDARecyclerViewAdapter<RDAGooglePlayApplication, RDAApplicationsRecyclerViewAdapter.RDAGooglePlayApplicationViewHolder> {

    private @LayoutRes
    int itemLayoutId = R.layout.rda_application_view_item_lib;

    @Inject
    RDAApplicationsRecyclerViewAdapter() {

    }

    @Override
    public void onBindViewHolder(@NonNull RDAGooglePlayApplicationViewHolder rdaGooglePlayApplicationViewHolder, int position) {

        RDAGooglePlayApplication rdaGooglePlayApplication = getItem(position);

        rdaGooglePlayApplicationViewHolder.nameTextView.setText(rdaGooglePlayApplication.getNameTurkish());
        rdaGooglePlayApplicationViewHolder.descriptionTextView.setText(rdaGooglePlayApplication.getDescriptionTurkish());
    }

    @Override
    protected RDAGooglePlayApplicationViewHolder getViewHolderInstance(View view) {
        return new RDAGooglePlayApplicationViewHolder(view);
    }

    void setItemLayoutId(int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    protected int getItemLayout() {
        return itemLayoutId;
    }

    public static class RDAGooglePlayApplicationViewHolder extends RecyclerView.ViewHolder {

        protected RDATextView nameTextView;
        protected RDATextView descriptionTextView;


        public RDAGooglePlayApplicationViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.applicationView_textView_appName);

            descriptionTextView = itemView.findViewById(R.id.applicationView_textView_appDescription);
        }
    }
}
