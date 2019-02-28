package pl.com.bubka.daggersample.dagger;

import dagger.Binds;
import dagger.Module;
import pl.com.bubka.daggersample.car.DieselEngine;
import pl.com.bubka.daggersample.car.EngineInterface;

@Module
public abstract class DieselEngineModule {

    @Binds
    abstract EngineInterface bindsEngine(DieselEngine dieselEngine);
}
