package pl.com.bubka.daggersample;

import android.util.Log;

public class Tires {
    //AS example we dont own this class, so we cannot annotate it with @Inject at constructor

    private static final String TAG = "Car";

    public void inflate(){
        Log.i(TAG, "inflate()");
    }
}
