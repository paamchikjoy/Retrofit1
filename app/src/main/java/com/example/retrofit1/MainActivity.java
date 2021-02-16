package com.example.retrofit1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit
                            .Builder()
                            .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);



    Call<OurMainData> call=   ourRetrofitClient.getData("9D5SKjEJdPEXrpRnpq2yWBZgmvVwg6NCm7jnH5AZqYe6OQFdZhwKGuDcbL7u");

        call.enqueue(new Callback<OurMainData>() {
            @Override
            public void onResponse(Call<OurMainData> call, Response<OurMainData> response) {
            if (response.isSuccessful())
            {
                List <ObjectData> list= response.body().getData();
                for (ObjectData objectData : list)
                {
                    Log.d("id",String.valueOf(objectData.getId()));
                    Log.d("name",String.valueOf(objectData.getName()));
                    Log.d("resource",String.valueOf(objectData.getResource()));
                    Log.d("updatedAt",String.valueOf(objectData.getUpdatedAt()));
                }
            }
            else
            {
                Log.d("response","failure");
            }


            }

            @Override
            public void onFailure(Call<OurMainData> call, Throwable t) {
                Log.d("response","failure");

            }
        });
    }


}