package pl.com.bubka.daggersample.dagger;

import dagger.BindsInstance;
import dagger.Component;
import pl.com.bubka.daggersample.car.Car;
import pl.com.bubka.daggersample.MainActivity;

//Component creates and stores our objects, and than provides them to us. Aka injector.
@Component(modules = {WheelsModule.class, PetrolEngineModule.class}) //we sawp here between DieselEngineModule and PetrolEngineModule, which makes it easy to test. However we cannot put two modules at same time, cause dagger doesnt know which omne to use
public interface CarComponent {

    /***
     * method name doesnt matter, the return type does. No method body, it is just interface. We dont need to specify how this methods
     * works because dagger does it for us, thanks to the help of annotetion processor.
     * ALtough, as I said name doesnt matter, but depending on how we name it, Dagger will name the providing method the same in the class
     * it generates for our component
     */
    Car getCar();

    //we cant declare super class like Activity, we have to make this for every activity where we want to inject dependenceis
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder{
        //here we define API for  our car component builder by ourselves. Thanks to this we can specify which methods we want to be available
        //on our generated DaggerCarComponent class at .build() method

        @BindsInstance //simple java builder pattern, allows method chaincalls on the builder
        Builder horsePower(int horsePower); //Thanks to this solution, our PetrolEngine can still stay abstract and we dont need to modify it and dagger still no need to instantiate it which is more performance efficient

        CarComponent build(); //no body, dagger will implement it automacilyy. We override build definition

    }

}
