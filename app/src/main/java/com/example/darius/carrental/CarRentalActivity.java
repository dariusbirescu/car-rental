package com.example.darius.carrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darius.carrental.R;

public class CarRentalActivity extends AppCompatActivity {

    private TextView tvModel,tvPrice,tvYear;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        tvModel = (TextView) findViewById(R.id.Model);
        tvPrice = (TextView) findViewById(R.id.Price);
        tvYear = (TextView) findViewById(R.id.Year);
        img = (ImageView) findViewById(R.id.carthumbnail);

        // Recieve data
        Intent intent = getIntent();
        String Model = intent.getExtras().getString("Model");
        String Year = intent.getExtras().getString("Year");
        String Price = intent.getExtras().getString("Price");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values

        tvModel.setText(Model);
        tvPrice.setText(Price);
        tvYear.setText(Year);
        img.setImageResource(image);


    }
}
