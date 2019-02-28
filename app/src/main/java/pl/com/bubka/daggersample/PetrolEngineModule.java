package pl.com.bubka.daggersample;

import dagger.Module;
import dagger.Provides;

@Module
public class PetrolEngineModule {

    @Provides
    static EngineInterface provideEngine(PetrolEngine petrolEngine){ //we have oncstructor inection in petrol engine so no need to provide it here
        return petrolEngine;
    }
}
