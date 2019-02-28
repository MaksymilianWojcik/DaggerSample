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

//    @Binds - we dont have @inject anymore iun DeieselEngine, so we dont need @Binds, as to use @BINDS we need an constructor with @Inject
    @Provides
    EngineInterface provideEngine(){
        return new DieselEngine(horsePower);
    }
}
