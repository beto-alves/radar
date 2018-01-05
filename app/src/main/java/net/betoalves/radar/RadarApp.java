package net.betoalves.radar;

import android.app.Application;

/**
 * Created by beto on 02/01/18.
 * BaseApp Class
 */

public class RadarApp extends Application {

    private static RadarApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static RadarApp getInstance() {
        return instance;
    }

}