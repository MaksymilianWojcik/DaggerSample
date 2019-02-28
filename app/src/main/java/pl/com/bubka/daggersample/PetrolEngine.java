package pl.com.bubka.daggersample;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements EngineInterface {

    private static final String TAG = "Car";

    @Inject
    public PetrolEngine(){}

    @Override
    public void start() {
        Log.i(TAG, "start petrol engine");
    }
}
