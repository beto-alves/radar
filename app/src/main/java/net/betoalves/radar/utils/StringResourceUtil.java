package net.betoalves.radar.utils;

import android.content.Context;
import android.support.annotation.StringRes;

import net.betoalves.radar.RadarApp;

/**
 * Created by beto on 02/01/18.
 * Helper para instanciação de strings res em classe onde não existe contexto.
 */

public class StringResourceUtil {

    private static StringResourceUtil instance;

    public static StringResourceUtil getInstance() {
        if(instance == null){
            instance = new StringResourceUtil();
        }
        return instance;
    }

    private Context context;

    public Context getContext() {
        if(context == null){
            context = RadarApp.getInstance();
        }
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getString(@StringRes int resource){
        return getContext().getString(resource);
    }

}
