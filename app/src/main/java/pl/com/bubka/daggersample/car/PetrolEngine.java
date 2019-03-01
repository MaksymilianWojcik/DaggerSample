package pl.com.bubka.daggersample.car;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements EngineInterface {

    private static final String TAG = "Car";

    private int horsePower;

    @Inject
    public PetrolEngine(int horsePower){
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.i(TAG, "start petrol engine with horse Power: " + horsePower);
    }
}
