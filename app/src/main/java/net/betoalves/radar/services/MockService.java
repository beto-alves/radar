package net.betoalves.radar.services;

import net.betoalves.radar.models.ApiResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by beto on 02/01/18.
 */

public interface MockService {

    @GET("v2/5a1d51302e0000492a48b78f")
    Observable<List<ApiResponse>> getMockData();

}