package net.betoalves.radar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by beto on 04/01/18.
 */

public class ApiResponse {

    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}