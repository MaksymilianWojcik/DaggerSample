package pl.com.bubka.daggersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import pl.com.bubka.daggersample.car.Car;
import pl.com.bubka.daggersample.dagger.CarComponent;
import pl.com.bubka.daggersample.dagger.DaggerCarComponent;
import pl.com.bubka.daggersample.dagger.DieselEngineModule;

public class MainActivity extends AppCompatActivity {

    @Inject //when @Inject on field, field cannot be private! or final!
            Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When we build the app, Dagger create a class DaggerCLASSComponent, from our CLASS that we provided in the @component.
//        CarComponent component = DaggerCarComponent.create(); //create() can be called only when we dont gave arguments
        CarComponent component = DaggerCarComponent.builder()
//                .dieselEngineModule(new DieselEngineModule(100))
                .horsePower(150) //tghanks to the @Builder we created in PetrolEngineModule. This value will be added to the dependency graph and dagger will use it whenever we need and integer
                .engineCapacity(1400)
                .build();
        component.inject(this);
//        car = component.getCar(); //It looks that there is a Car return type methods, so it prepares the method that returns the car
        //Why in Car class we just put @Inject on field and the field will be injected, but in MainActivity we have to make .inject()?
        //This is because field and method injection are only automatically injected if we also do constructor injection, as this is
        //what triggers the whole process. In activity we cant do constructor injection, so we have to trigger constructor process manually
        //by calling inject. The same way method in MainActivity with @Inject would be called, but generally we dont do method injection in activitys.


        car.drive();
    }
}

/*
@Modules and @Provides
Quick recap: in a nutshell, dagger creates objects and provides them at a proper time, but at ceratin point we have to teach dagger how to do this.
Anbd we know one way: by constructor. But this is not always that simple - what if we dont own the class and cannot annotate constructor?
For example lets say it comes from some 3rd party. See Rim & Tires & Wheels for example.
So as we have no access to construcotr, so here as help comes Modules and @Provides annotation.

@Binds
For providing interfaces.
When we instantiate class, we already know how to do this to inject / provide dependency for it.
But what if we need to inject a interface?
As we know, interfaces dont have constructors, so constructor injection falls out.
We have to use modules here and provides

After we have added 2 modules for Petrol and Dioesel engine and their interface, we can easily swap between them for the
inection in Car class constructor, by simply chaning in the CarComponent the module class, from one to other.


Injecting values at runtime
With @Provides and using different way of instantiating CarComponent in MainActivity

@Component.Builder & @BindsInstance & @Named

 */