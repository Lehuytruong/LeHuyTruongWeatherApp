package com.demo.lehuytruongweatherapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.demo.lehuytruongweatherapp.R;
import com.demo.lehuytruongweatherapp.adapter.HourAdapter;
import com.demo.lehuytruongweatherapp.model.Weather;
import com.demo.lehuytruongweatherapp.network.ApiManager;


import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTem = (TextView)findViewById(R.id.tvTime);
        tvStatus = (TextView) findViewById(R.id.tvStatus);


        //B1:
        getHour();

    }

    private void getHour() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service = retrofit.create(ApiManager.class);
        service.gethour().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.body() == null)
                    return;
                List<Weather> listWeather = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this,listWeather);
                rvHour.setAdapter(adapter);

                Weather weather = listWeather.get(0);
                tvTem.setText((weather.getTemperature().getValue().intValue()+"°"));
                tvStatus.setText(weather.getIconPhrase());
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {

            }
        });


    }
}