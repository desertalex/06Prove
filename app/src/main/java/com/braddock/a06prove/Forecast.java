package com.braddock.a06prove;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Forecast extends AsyncTask<String, Void, ArrayList> {
    ForecastList list;
    String city;
    String url;
    Context context;
    ListView listView;

     public Forecast(Context context, ListView listView, String city) {
         this.context = context;
         this.listView = listView;
         this.city = city;
         this.url = "https://api.openweathermap.org/data/2.5/forecast?q=" +
                 city + "&units=imperial&apiKey=83d8701e041f1ee7adffaf1d8a7d49ab";
         System.out.println("Constructor finished");
     }


    @Override
    protected ArrayList doInBackground(String... city) {
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream responseStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            String inputLine = reader.readLine();

            Gson gson = new Gson();

            list= gson.fromJson(inputLine, ForecastList.class);

            return list.getListAsString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList list) {
        System.out.println("Post execute began");
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, list);
        System.out.println("Array adapter created");
        listView.setAdapter(arrayAdapter);
        System.out.println("listView.setAdapter(arrayAdapter);");
        //super.onPostExecute(list);
    }
}
