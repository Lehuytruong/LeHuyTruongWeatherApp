package com.demo.lehuytruongweatherapp.network;

import com.demo.lehuytruongweatherapp.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    public static String BASE_URL = "http://dataservice.accuweather.com";

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=0UP3ZxdXQ1ZAATFy7cxUx672FSrmTO25&language=vi-vn&metric=true")
    Call<List<Weather>>gethour();

    @GET("/forecasts/v1/daily/5day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
            Call<List<Weather>>getDay();
}
