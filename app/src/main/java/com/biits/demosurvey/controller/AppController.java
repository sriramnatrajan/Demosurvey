package com.biits.demosurvey.controller;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
//import org.acra.ACRA;
//import org.acra.ReportingInteractionMode;
//import org.acra.annotation.ReportsCrashes;

//
//@ReportsCrashes( // will not be used
//        mailTo = "shil.snehasis@gmail.com",
//        mode = ReportingInteractionMode.TOAST,
//        resToastText = R.string.app_name)
public class AppController extends Application {
private RequestQueue mRequestQueue ;
private static AppController mInstance ;
public static final String TAG = AppController.class.getSimpleName();

@Override
public void onCreate() {
    super.onCreate();
    mInstance = this ;

//    //ACRA for crash report
//    ACRA.init(this);
//    super.onCreate();
}


public static AppController getInstance(){
        return mInstance ;
}

public RequestQueue getRequestQueue(){
    if(mRequestQueue == null)
        mRequestQueue = Volley.newRequestQueue(getApplicationContext()) ;
    return  mRequestQueue ;
}

public <T> void addToRequestQueue(Request<T> req, String tag) {
    req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
    getRequestQueue().add(req);
}

public <T> void addToRequestQueue(Request<T> req) {
    req.setTag(TAG);
    getRequestQueue().add(req);
}

public void cancelPendingRequests(Object tag) {
    if (mRequestQueue != null) {
        mRequestQueue.cancelAll(tag);
    }
}


}
