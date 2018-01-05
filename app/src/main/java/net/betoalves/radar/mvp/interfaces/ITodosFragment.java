package net.betoalves.radar.mvp.interfaces;

import net.betoalves.radar.models.ApiResponse;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by beto on 03/01/18.
 */

public interface ITodosFragment {

    void toast(String response);

    void setRecyclerViewContent(List<ApiResponse> apiResponseList);

}