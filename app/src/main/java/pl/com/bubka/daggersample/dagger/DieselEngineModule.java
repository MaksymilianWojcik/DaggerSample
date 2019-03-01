package pl.com.bubka.daggersample.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import pl.com.bubka.daggersample.car.DieselEngine;
import pl.com.bubka.daggersample.car.EngineInterface;

@Module
public class DieselEngineModule {

    private int horsePower;

    public DieselEngineModule(int horsePower){
        this.horsePower = horsePower;
    }

    @Provides //now dagger can inject this int whenever int is needed, and we can now add @Inject at dieselengine constructor
    int provideHorsePower(){ //so we basically say, hwenever integer is needed take this
        return horsePower;
    }

//    @Binds - we dont have @inject anymore iun DeieselEngine, so we dont need @Binds, as to use @BINDS we need an constructor with @Inject
    @Provides
    EngineInterface provideEngine(DieselEngine dieselEngine){ //now we can add DieselEngine as an argument here and just return it
//        return new DieselEngine(horsePower);
        return dieselEngine; //now this will work, cause dagger now knows where to get horsePOwer value from
    }
}
