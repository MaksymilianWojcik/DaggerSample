package pl.com.bubka.daggersample.car;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements EngineInterface {

    private static final String TAG = "Car";

    @Inject
    public DieselEngine(){}

    @Override
    public void start() {
        Log.i(TAG, "start diesel engine");
    }
}
