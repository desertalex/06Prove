package com.braddock.a06prove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tempButtonClick(View view) {
        EditText cityEditText = (EditText) findViewById(R.id.editTextCityName);
        String city = cityEditText.getText().toString();
        new Thread(new CurrentTemperature(this, city)).start();
    }

    public void forecastButtonClick(View view) {
        EditText cityEditText = (EditText) findViewById(R.id.editTextCityName);
        String city = cityEditText.getText().toString();
        ListView listView = (ListView) findViewById(R.id.listViewInformation);
        Forecast forecast = new Forecast(MainActivity.this, listView, city);
        System.out.println("01");
        forecast.execute();
    }
}
