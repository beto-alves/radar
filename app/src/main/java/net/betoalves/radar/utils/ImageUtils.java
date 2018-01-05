package net.betoalves.radar.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by beto on 05/01/18.
 * Utilizado para centralizar e fornecer acesso aos metodos do picasso
 */

public class ImageUtils {

    public static void showImage(String path, final ImageView im) {
        Picasso.with( im.getContext() )
                .load(path)
                .into( im );
    }

}