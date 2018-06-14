package com.example.user.allinoneteacher;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class sq extends AppCompatActivity {
TextToSpeech toSpeech;
int r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView im3=(ImageView) findViewById(R.id.imageView3);
        ImageView im5=(ImageView) findViewById(R.id.imageView5);
        ImageView im6=(ImageView) findViewById(R.id.imageView6);
        ImageView im7=(ImageView) findViewById(R.id.imageView7);
        toSpeech=new TextToSpeech(sq.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                r=toSpeech.setLanguage(Locale.UK);
            }
        });


        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a rolling dai", TextToSpeech.QUEUE_FLUSH,null);
            }
        });


        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a watch", TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a chess board", TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("This is a gift box", TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }
}
