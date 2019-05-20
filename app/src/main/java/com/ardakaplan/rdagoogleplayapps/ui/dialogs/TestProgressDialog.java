package com.ardakaplan.rdagoogleplayapps.ui.dialogs;

import android.app.Activity;

import com.ardakaplan.rdalibrary.base.ui.dialogs.RDAProgressDialog;

@SuppressWarnings("unused")
public class TestProgressDialog extends RDAProgressDialog {

    public TestProgressDialog(Activity activity) {
        super(activity);

        setProgressBarColor();
    }

    public TestProgressDialog(Activity activity, int theme) {
        super(activity, theme);

        setProgressBarColor();
    }

    private void setProgressBarColor() {
        
    }
}
