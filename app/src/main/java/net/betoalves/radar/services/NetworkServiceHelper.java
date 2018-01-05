package net.betoalves.radar.services;

import com.google.gson.JsonArray;

import net.betoalves.radar.utils.Constants;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beto on 01/01/18.
 * Helper criado para centralizar o código de criação e acesso da retrofit
 */

public class NetworkServiceHelper {

    public MockService getMockService() {
        Retrofit retrofit = createRetrofit();
        return retrofit.create(MockService.class);
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createHttpCliente())
                .build();
    }

    private OkHttpClient createHttpCliente() {
        return new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.MINUTES)
                .connectTimeout(3, TimeUnit.MINUTES)
                .build();
    }

}