package com.ardakaplan.rdagoogleplayappslib.rdaapps;

import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ardakaplan.rdagoogleplayappslib.R;
import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.ardakaplan.rdalibrary.base.ui.adapters.RDARecyclerViewAdapter;
import com.ardakaplan.rdalibrary.helpers.RDAApplicationHelpers;
import com.ardakaplan.rdalibrary.managers.LanguageManager;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class RDAApplicationsRecyclerViewAdapter extends RDARecyclerViewAdapter<RDAGooglePlayApplication, RDAApplicationsRecyclerViewAdapter.RDAGooglePlayApplicationViewHolder> {

    private @LayoutRes
    int itemLayoutId = R.layout.rda_application_view_item_lib;

    private @ColorInt
    int installedAppBackgroundColor;

    @Inject
    RDAApplicationHelpers rdaApplicationHelpers;

    @Inject
    LanguageManager languageManager;

    @Inject
    RDAApplicationsRecyclerViewAdapter() {

    }

    void setInstalledAppBackgroundColor(@ColorInt int installedAppBackgroundColor) {
        this.installedAppBackgroundColor = installedAppBackgroundColor;
    }

    @Override
    public void onBindViewHolder(@NonNull RDAGooglePlayApplicationViewHolder holder, int position) {

        RDAGooglePlayApplication rdaGooglePlayApplication = getItem(position);

        if (languageManager.getSelectedLanguage().equals(LanguageManager.Language.TURKISH)) {

            holder.nameTextView.setText(rdaGooglePlayApplication.getNameTurkish());

            holder.descriptionTextView.setText(rdaGooglePlayApplication.getDescriptionTurkish());

        } else {

            holder.nameTextView.setText(rdaGooglePlayApplication.getNameEnglish());

            holder.descriptionTextView.setText(rdaGooglePlayApplication.getDescriptionEnglish());
        }

        Picasso.with(holder.itemView.getContext()).load(rdaGooglePlayApplication.getIconUrl()).into(holder.appLogoImageView);

        if (rdaApplicationHelpers.isApplicationInstalled(rdaGooglePlayApplication.getPackageName())) {

            holder.itemView.setBackgroundColor(installedAppBackgroundColor);

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

        protected TextView nameTextView;
        protected TextView descriptionTextView;
        protected ImageView appLogoImageView;


        public RDAGooglePlayApplicationViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.applicationView_textView_appName);

            descriptionTextView = itemView.findViewById(R.id.applicationView_textView_appDescription);

            appLogoImageView = itemView.findViewById(R.id.applicationView_imageView_logo);
        }
    }
}
