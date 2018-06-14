package com.example.user.allinoneteacher;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class k extends AppCompatActivity {
    TextToSpeech toSpeech;
    int r;
    private final int RCSO = 143;
    private TextView SVO;

    //private TextView showViceOutput;
    private Button openMic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView next= (ImageView) findViewById(R.id.next);
        ImageView pri= (ImageView) findViewById(R.id.pri);
        toSpeech=new TextToSpeech(k.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                r=toSpeech.setLanguage(Locale.UK);
            }
        });


        //ImageView k=(ImageView) findViewById(R.id.i1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("L",TextToSpeech.QUEUE_FLUSH,null);
                Intent i2=new Intent(k.this,l.class);
                startActivity(i2);
            }
        });

        pri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("J",TextToSpeech.QUEUE_FLUSH,null);
                Intent i2=new Intent(k.this,j.class);
                startActivity(i2);
            }
        });

        Button sb=(Button) findViewById(R.id.sound);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak("K",TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        Button test=(Button) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnToOpenMic();
            }
        });

    }


    private void btnToOpenMic() {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.UK);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi Speak Now.......!");
        try {
            startActivityForResult(i, RCSO);

        } catch (ActivityNotFoundException ex) {
        }

    }

    @Override

    protected void onActivityResult(int reqcode, int resultcode, Intent data) {
        super.onActivityResult(reqcode, resultcode, data);
        switch (reqcode) {
            case RCSO: {
                if (resultcode == RESULT_OK && null != data) {
                    ArrayList<String> voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String str=(String) voiceInText.get(0);
                    if(str.equals("K") || str.equals("k")  )
                    {
                        Intent i1=new Intent(k.this,correct.class);
                        startActivity(i1);
                    }
                    else
                    {

                        Intent i2=new Intent(k.this,wrong.class);
                        startActivity(i2);
                    }

                }
            }
            break;
        }

    }

}
