package com.example.darius.carrental;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.darius.carrental.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class CarRentalActivity extends AppCompatActivity {

    private TextView tvModel,tvPrice,tvYear;
    private ImageView img;
    private Button rentCar;
    private StorageReference mStorageReference;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        rentCar=findViewById(R.id.rentCar);

        tvModel = (TextView) findViewById(R.id.Model);
        tvPrice = (TextView) findViewById(R.id.Price);
        tvYear = (TextView) findViewById(R.id.Year);
        img = (ImageView) findViewById(R.id.carthumbnail);
        ImageView _imv;
        Bitmap _bitmap=null;
        // Recieve data
        Intent intent = getIntent();
        System.out.println(intent.getExtras());
        String Model = intent.getExtras().getString("Model");
        String Year = intent.getExtras().getString("Year");
        String Price = intent.getExtras().getString("Price");
        String url =intent.getExtras().getString("Url");
        final String id = intent.getExtras().getString("id");


        rentCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference=FirebaseDatabase.getInstance().getReference("uploads");
                mDatabaseReference.child(id).setValue(null);
                startActivity(new Intent(getBaseContext(), NavbarActivity.class));
            }
        });
        tvModel.setText(Model);
        tvPrice.setText(Price);
        tvYear.setText(Year);
        Glide.with(getBaseContext()).load(url).into(img);


    }
}
