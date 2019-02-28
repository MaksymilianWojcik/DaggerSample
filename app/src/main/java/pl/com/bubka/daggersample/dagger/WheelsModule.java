package pl.com.bubka.daggersample.dagger;

import dagger.Module;
import dagger.Provides;
import pl.com.bubka.daggersample.car.Rims;
import pl.com.bubka.daggersample.car.Tires;
import pl.com.bubka.daggersample.car.Wheels;

@Module
public class WheelsModule {

    @Provides //as our provides methods dont depend to any instance state of the module like in this class, we can make those methods static - which adds a little performonce,
    //cause dagger will call this methods from the class instead of instantiating this module, its just java thing
    static Rims provideRims(){
        return new Rims();
    }

    @Provides
    static Tires provideTires(){
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides //as we cannot use constructor injectin there, we have to also provide it manually
    static Wheels provideWheels(Rims rims, Tires tires){ //dagger knows how to provide those dependenceis from above, and it will be injected by dagger here
        return new Wheels(rims, tires);
    }

}
