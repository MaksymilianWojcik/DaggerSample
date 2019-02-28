package pl.com.bubka.daggersample.car;

import javax.inject.Inject;

public class Remote {

    private static final String TAG = "Remote";

    @Inject
    public Remote(){}

    public void setListener(Car car) {
    }
}
