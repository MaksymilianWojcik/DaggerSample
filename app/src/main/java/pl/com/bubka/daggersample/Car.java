package pl.com.bubka.daggersample;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";

    //For example we could inject those here also at some point, but we dont want it - cause we want to keep those field private
    //If we have access to contructor, we should choose constructor injection
    //Field injection is meant for framework types, that the Android system initiaites - like activities/fragments
    //We dont create like our MainActivity object, which means we cant do constructor injection in MainActivity
    //ALSO IMPORTANT: If we would inject by field here and remove from constructor, dagger first creates constructor and its injections,
    //than field injection, and than calls the injected methods
    private Wheels wheels;

    //Why here we just put @Inject on field and the field will be injected, but in MainActivity we have to make .inject()?
    //This is because field and method injection are only automatically injected if we also do constructor injection, as this is
    //what triggers the whole process. In activity we cant do constructor injection, so we have to trigger constructor process manually
    //by calling inject. The same way method in MainActivity with @Inject would be called, but generally we dont do method injection in activitys.
//    private Engine engine;
    private EngineInterface engineInterface;

    //We pass dependenceis in constructor, we dont want to create object here
    @Inject //thanks to this dagger knows how to instantiate a Car object. Of course we have to also inject wheels and engine as we dont instantiate it here
    public Car(Wheels wheels, EngineInterface engineInterface/*Engine engine*/) {
        this.wheels = wheels;
        this.engineInterface = engineInterface;
//        this.engine = engine;
    }
    //: If we would inject by field here and remove from constructor, dagger first creates constructor and its injections,
    //    //than field injection, and than calls the injected methods

    public void drive(){
        engineInterface.start();
        Log.i(TAG, "drive()  ");
    }

    /***
     * Method injection
     * By adding @Inject annotation over method, dagger will automatically run this method after constructor (after object is fully instantiated)
     * This is a good example, cause we would like to setListener on this Car class, but best way to do this is when the object is fully instantiated.
     * If we would do it in constructor, the object could not be fully instantiated, so this i quite good scenario.
     * So summary, we dont need to call this method in constructor, dagger does it for us by annotating it with @Inject.
     * The same way it provides constructor arguments, so it will create Remote and execute this method
     *
     */
    @Inject
    public void enableRemote(Remote remote){
        Log.i(TAG, "enableRemote() ");
        remote.setListener(this);
    }
}
