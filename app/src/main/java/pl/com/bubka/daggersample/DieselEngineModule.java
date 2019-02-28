package pl.com.bubka.daggersample;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    @Binds
    abstract EngineInterface bindsEngine(DieselEngine dieselEngine);
}
