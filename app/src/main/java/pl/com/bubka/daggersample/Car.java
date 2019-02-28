package pl.com.bubka.daggersample;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";

    //For example we could inject those here also at some point, but we dont want it - cause we want to keep those field private
    //If we have access to contructor, we should choose constructor injection
    //Field injection is meant for framework types, that the Android system initiaites - like activities/fragments
    //We dont create like our MainActivity object, which means we cant do constructor injection in MainActivity
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
