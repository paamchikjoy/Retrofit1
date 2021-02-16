package com.example.retrofit1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OurRetrofitClient {

    @GET("continents")
    Call<OurMainData> getData(@Query("api_token") String api_token);
}
