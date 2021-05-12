package com.demo.lehuytruongweatherapp.adapter;

import android.app.Activity;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.lehuytruongweatherapp.R;
import com.demo.lehuytruongweatherapp.activity.MainActivity;
import com.demo.lehuytruongweatherapp.model.Weather;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter {







    private Activity activity;
    private List<Weather> listWeather;

    public HourAdapter(Activity activity, List<Weather> listWeather) {
        this.activity = activity;
        this.listWeather = listWeather;
    }

    public HourAdapter(MainActivity mainActivity, List<Weather> listWeather) {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_hour,parent,false);
        HourHolder holder = new HourHolder(itemView);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HourHolder vh = (HourHolder) holder;
        Weather weather = listWeather.get(position);
        vh.tvTime.setText(convertTime(weather.getDateTime()));
        vh.tvTem.setText(weather.getTemperature().getValue()+"");
        String url ="";
        if (Weather.getWeatherIcon()<10){
            url = "https://developer.accuweather.com/sites/default/files/0" + weather.getWeatherIcon() +"-s.png";
        }else {
            url= "https://developer.accuweather.com/sites/default/files/" + weather.getWeatherIcon() + "-s.png";
        }
        Glide.with(activity).load(url).into(vh.icon);

    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }


    public static class HourHolder extends RecyclerView.ViewHolder{

        private TextView tvTime;
        private ImageView icon;
        private TextView tvTem;

        public HourHolder(View itemView){
            super(itemView);
            tvTime = (TextView)itemView.findViewById(R.id.tvTime);
            icon = (ImageView)itemView.findViewById(R.id.ivicon);
            tvTem = (TextView)itemView.findViewById(R.id.tvTem);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }


}
