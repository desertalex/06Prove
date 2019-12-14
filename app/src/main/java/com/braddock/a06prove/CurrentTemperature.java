package com.braddock.a06prove;

import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CurrentTemperature implements Runnable {
    private String city;
    private String url;
    private WeakReference<Activity> activityRef;

    public CurrentTemperature(Activity activity, String city) {
        this.activityRef = new WeakReference<Activity>(activity);
        this.city = city;
        this.url = "https://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&units=imperial&apiKey=83d8701e041f1ee7adffaf1d8a7d49ab";
    }

    //@Override
    public void run() {
        // creates URL object and URLConnection and connects to the internet
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream responseStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            String inputLine = reader.readLine();

            Gson gson = new Gson();

            Weather weather = gson.fromJson(inputLine, Weather.class);
            final float temp = weather.getTemp();


            final Activity activity = activityRef.get();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // This is the code that will run on the UI thread.
                    String s = Float.toString(temp);
                    Toast toast = Toast.makeText(activity, s + "° Fahrenheit", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
