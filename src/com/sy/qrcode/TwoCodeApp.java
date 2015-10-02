package com.sy.qrcode;

import android.app.Application;

public class TwoCodeApp extends Application{
    
    private static TwoCodeApp mInstance;
    
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mInstance = this;
    }
    
    public static TwoCodeApp getInstance() {
        return mInstance;
    }
}
