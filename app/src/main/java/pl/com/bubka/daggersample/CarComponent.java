package pl.com.bubka.daggersample;

import dagger.Component;

//Component creates and stores our objects, and than provides them to us. Aka injector.
@Component
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

}
