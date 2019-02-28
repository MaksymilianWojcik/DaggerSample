package pl.com.bubka.daggersample.car;

public class Wheels {

    private static final String TAG = "Wheels";

    private Rims rims;
    private Tires tires;

//    @Inject - this wouldnt work, cause we cannot just like this inject Rims and Tires in these classes, we have no acces to constructor
    public Wheels(Rims rims, Tires tires){
        this.rims = rims;
        this.tires = tires;
    }
}
