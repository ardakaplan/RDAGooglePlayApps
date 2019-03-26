package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ardakaplan.rdagoogleplayappslib.R;
import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdalibrary.base.ui.adapters.RDARecyclerViewAdapter;
import com.ardakaplan.rdalibrary.base.ui.views.fontables.RDATextView;
import com.ardakaplan.rdalibrary.helpers.RDAApplicationHelpers;
import com.ardakaplan.rdalibrary.interfaces.RDAItemClickListener;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class RDAApplicationsRecyclerViewAdapter extends RDARecyclerViewAdapter<RDAGooglePlayApplication, RDAApplicationsRecyclerViewAdapter.RDAGooglePlayApplicationViewHolder> {

    private @LayoutRes
    int itemLayoutId = R.layout.rda_application_view_item_lib;

    private @ColorRes
    int installedAppBackgroundColorId;

    private RDAItemClickListener<RDAGooglePlayApplication> rdaItemClickListener;

    @Inject
    RDAApplicationHelpers rdaApplicationHelpers;

    @Inject
    RDAApplicationsRecyclerViewAdapter() {

    }

    public void setRdaItemClickListener(RDAItemClickListener<RDAGooglePlayApplication> rdaItemClickListener) {
        this.rdaItemClickListener = rdaItemClickListener;
    }

    public void setInstalledAppBackgroundColorId(int installedAppBackgroundColorId) {
        this.installedAppBackgroundColorId = installedAppBackgroundColorId;
    }

    @Override
    public void onBindViewHolder(@NonNull RDAGooglePlayApplicationViewHolder holder, int position) {

        RDAGooglePlayApplication rdaGooglePlayApplication = getItem(position);

        holder.nameTextView.setText(rdaGooglePlayApplication.getNameTurkish());
        holder.descriptionTextView.setText(rdaGooglePlayApplication.getDescriptionTurkish());

        Picasso.with(holder.itemView.getContext()).load(rdaGooglePlayApplication.getIconUrl()).into(holder.appLogoImageView);

        if (rdaApplicationHelpers.isApplicationInstalled(rdaGooglePlayApplication.getPackageName())) {

            holder.itemView.setBackgroundColor(holder.itemView.getContext().getResources().getColor(installedAppBackgroundColorId));

        } else {

            holder.itemView.setBackgroundColor(0x00000000);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rdaItemClickListener.onItemClick(rdaGooglePlayApplication);
            }
        });
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
        protected ImageView appLogoImageView;


        public RDAGooglePlayApplicationViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.applicationView_textView_appName);

            descriptionTextView = itemView.findViewById(R.id.applicationView_textView_appDescription);

            appLogoImageView = itemView.findViewById(R.id.applicationView_imageView_logo);
        }
    }
}
