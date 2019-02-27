package pl.com.bubka.daggersample;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";

    private Wheels wheels;
    private Engine engine;

    //We pass dependenceis in constructor, we dont want to create object here
    @Inject //thanks to this dagger knows how to instantiate a Car object. Of course we have to also inject wheels and engine as we dont instantiate it here
    public Car(Wheels wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public void drive(){
        Log.i(TAG, "drive()  ");
    }
}
