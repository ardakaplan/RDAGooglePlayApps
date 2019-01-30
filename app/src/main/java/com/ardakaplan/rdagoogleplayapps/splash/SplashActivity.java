package com.ardakaplan.rdagoogleplayapps.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import com.ardakaplan.rdagoogleplayapps.R;
import com.ardakaplan.rdagoogleplayapps.storage.StorageManager;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.RDAInteractionException;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.ButtonClickListener;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.ButtonType;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.RDADialog;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalibrary.helpers.RDAApplicationHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {


    @BindView(R.id.button_test)
    Button testButton;

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @Inject
    RDAApplicationHelpers rdaApplicationHelpers;

    @Inject
    StorageManager storageManager;

    @Override
    protected void adjustApplicationTheme() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.splash_activity);

        presenter.attach(this);

        presenter.testPresenterContract();

        presenter.getList();

        RDALogger.info("VERSION CODE : " + rdaApplicationHelpers.getAppVersionCode());

        RDALogger.info("SHARED : " + storageManager.getSharedManager().getUsername());

        storageManager.getSharedManager().saveUsername("HAAAAAAAAAAAAAA");

        RDALogger.info("SHARED : " + storageManager.getSharedManager().getUsername());

        testButton.setText("DENEME");


    }

    @OnClick(R.id.button_test)
    void test() {

        RDALogger.info("TEST");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }

    @Override
    public void testViewContract() {

    }

    @Override
    public void setList(ArrayList<String> list) {
    }

    @Override
    public void onError(RDAInteractionException e) {

        e.printStackTrace();

        Toast.makeText(this, "HATA", Toast.LENGTH_SHORT).show();
    }

    private void showDialog() {

        RDADialog.showDialog(this, "DENEME", "DENEME BODY", "DENEME POSTIC", "NEEEEGAT", "NEUTRAA", 0, null, new ButtonClickListener() {

            @Override
            public void onClick(RDADialog rdaDialog, ButtonType buttonType) {

                switch (buttonType) {

                    case NEUTRAL:

                        Toast.makeText(SplashActivity.this, "NEUTRAL", Toast.LENGTH_SHORT).show();

                        break;

                    case NEGATIVE:

                        Toast.makeText(SplashActivity.this, "NEGATIVE", Toast.LENGTH_SHORT).show();

                        break;

                    case POSITIVE:

                        Toast.makeText(SplashActivity.this, "POSITIVE", Toast.LENGTH_SHORT).show();

                        break;
                }


            }
        });
    }

}