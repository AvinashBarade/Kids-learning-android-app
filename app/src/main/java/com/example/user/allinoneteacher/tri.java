package com.example.user.allinoneteacher;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class tri extends AppCompatActivity {
TextToSpeech toSpeech;
int r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tri);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView im3=(ImageView) findViewById(R.id.imageView3);
        ImageView im5=(ImageView) findViewById(R.id.imageView5);
        ImageView im6=(ImageView) findViewById(R.id.imageView6);
        ImageView im7=(ImageView) findViewById(R.id.imageView7);
        toSpeech=new TextToSpeech(tri.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                r=toSpeech.setLanguage(Locale.UK);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a  pizza", TextToSpeech.QUEUE_FLUSH,null);
            }
        });


        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a pyaramid", TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a  diamond", TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a  hangur", TextToSpeech.QUEUE_FLUSH,null);
            }
        });


    }
}
