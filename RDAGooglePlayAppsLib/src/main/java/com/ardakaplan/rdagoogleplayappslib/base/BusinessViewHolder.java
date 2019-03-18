package com.ardakaplan.rdagoogleplayappslib.base;

import android.view.View;

/**
 * Created by Arda Kaplan on 18-Mar-19 - 10:05
 */
public abstract class BusinessViewHolder {

    private View itemView;

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
        findViews(itemView);
    }

    public abstract void findViews(View itemView);
}
