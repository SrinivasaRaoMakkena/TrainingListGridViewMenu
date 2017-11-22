package com.example.srinivas.listviewwithbaseadapter;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
TextView welcome;
    ImageView detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        welcome = (TextView) findViewById(R.id.welcomeNote);
        detail = (ImageView) findViewById(R.id.imageDetail);

        Intent i = getIntent();

        setTitle(i.getStringExtra("text"));

        welcome.setText("Welcome to: "+i.getStringExtra("text"));
        detail.setImageResource(i.getIntExtra("image",0));


    }
}
