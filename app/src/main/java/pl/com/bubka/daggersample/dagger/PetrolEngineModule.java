package pl.com.bubka.daggersample.dagger;

import dagger.Binds;
import dagger.Module;
import pl.com.bubka.daggersample.car.EngineInterface;
import pl.com.bubka.daggersample.car.PetrolEngine;

@Module
public abstract class PetrolEngineModule {

    //Thanks to @Bind we write less code, and dagger can optimize the code under the hood more than @provides or even static @Provides
    //cause dagger never creates implementation for this class or this method, and it never calls this methods, it just instantiates
    // petrolEngine directly.
    //Important: we cannot use anymore @Provides in this class, as it is abstract, and for provides dagger needs to instantiate a module.
    //BUT: We can use static provides methods in here, cause they dont need an instance :)
    @Binds //instead of provide
    abstract EngineInterface bindsEngine(PetrolEngine petrolEngine); //we have oncstructor inection in petrol engine so no need to provide it here
}
