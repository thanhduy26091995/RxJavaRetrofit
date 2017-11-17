package com.hbbsolution.mproduction.modules.base;

import android.app.Application;

/**
 * Created by buivu on 20/09/2017.
 */

public class MProductionApplication extends Application {
    private static Application instance;

    public static Application getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
