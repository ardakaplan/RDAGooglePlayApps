package com.ardakaplan.rdagoogleplayappslib.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Arda Kaplan on 18-Mar-19 - 10:07
 */
public abstract class BusinessView<VH extends BusinessViewHolder> {

    private VH viewHolder;

    public BusinessView(VH viewHolder){
        this.viewHolder = viewHolder;
    }

    public void onViewCreated(ViewGroup containerView){
        View viewForHolder = LayoutInflater.from(containerView.getContext()).inflate(getLayout(), containerView, true);
        viewHolder.setItemView(viewForHolder);

        onViewHolderCreated(viewHolder);
    }

    public Context getContext() {
        return viewHolder.getItemView().getContext();
    }

    @LayoutRes
    protected abstract int getLayout();

    public void onViewDestroyed(){

    }

    public void onPause(){

    }

    public void onResume(){

    }

    public VH getViewHolder(){
        return viewHolder;
    }

    public abstract void onViewHolderCreated(VH viewHolder);
}