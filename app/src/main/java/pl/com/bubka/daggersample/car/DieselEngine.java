package pl.com.bubka.daggersample.car;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements EngineInterface {

    private static final String TAG = "Car";

    private int horsePower;

//    @Inject - can be removed, dagger anyway doesnt know where from provide horsePower. We have to call this constructor and pass this  value, not dagger
    @Inject //can now be added, when we have added @Provides with int in DieselEngineMOdule, so dagger will take this int, we dont have to do it manually anymore
    public DieselEngine(int horsePower){ //we want to pass it at runtime, when we buil a component. Liek just this it doesnt work, constructor cannot be created cause dagger doesnt know hwere to get from the horsePower int/ So we can remove @Inject
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.i(TAG, "start diesel engine with horsePower: " + horsePower);
    }
}
