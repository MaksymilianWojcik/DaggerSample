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

        car.drive();
    }
}
