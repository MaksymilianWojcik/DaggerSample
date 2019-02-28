package pl.com.bubka.daggersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject //when @Inject on field, field cannot be private! or final!
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When we build the app, Dagger create a class DaggerCLASSComponent, from our CLASS that we provided in the @component.
        CarComponent component = DaggerCarComponent.create();
        component.inject(this);
//        car = component.getCar(); //It looks that there is a Car return type methods, so it prepares the method that returns the car
        //Why in Car class we just put @Inject on field and the field will be injected, but in MainActivity we have to make .inject()?
        //This is because field and method injection are only automatically injected if we also do constructor injection, as this is
        //what triggers the whole process. In activity we cant do constructor injection, so we have to trigger constructor process manually
        //by calling inject. The same way method in MainActivity with @Inject would be called, but generally we dont do method injection in activitys.


        car.drive();
    }
}
