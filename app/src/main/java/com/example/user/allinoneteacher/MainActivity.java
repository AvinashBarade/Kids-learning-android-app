package com.example.user.allinoneteacher;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    private ShareActionProvider mshareActionProvider;
   // android.support.v4.app.FragmentTransaction fragmentTransaction;
    TextToSpeech toSpeech;
    int r;
    private ShareActionProvider sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView b1,b2,b3,b4,b5;
       // Menu m=(Menu) findViewById(R.id.);
        toSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                r=toSpeech.setLanguage(Locale.UK);
            }
        });

        b1=(ImageView) findViewById(R.id.b1);
        b2=(ImageView) findViewById(R.id.b2);
        b3=(ImageView) findViewById(R.id.b3);
        b4=(ImageView) findViewById(R.id.b4);
        b5=(ImageView) findViewById(R.id.b5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,NUMBERS.class);
                toSpeech.speak("OO N EE one", TextToSpeech.QUEUE_FLUSH,null);
                startActivity(i);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,a.class);
                toSpeech.speak("A", TextToSpeech.QUEUE_FLUSH,null);
                startActivity(i);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,rectangle.class);
                toSpeech.speak("rectangle", TextToSpeech.QUEUE_FLUSH,null);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,dog.class);
                toSpeech.speak("This is a dog", TextToSpeech.QUEUE_FLUSH,null);
                startActivity(i);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,br.class);
                toSpeech.speak("Put camera on your book", TextToSpeech.QUEUE_FLUSH,null);
                startActivity(i);

            }
        });




















        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.add(R.id.main+);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
         case R.id.action_settings:
                Intent i=new Intent(
                        Intent.ACTION_SEND
                );
                i.setType("text/plain");
             i.putExtra(Intent.EXTRA_TEXT,"THE FANTASTIC KID LEARNING APP DOWNLOAD FROM BELOW LINK\n www.fcpune.project.apk");
             startActivity(Intent.createChooser(i,"Share via"));
             break;

        }
        Toast.makeText(getApplicationContext(),"You click on share menu",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent i=null,choser=null;
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_camera:
                // Handle the camera action
                Toast.makeText(getApplicationContext(),"You click on About menu",Toast.LENGTH_SHORT).show();
                i=new Intent(MainActivity.this,about.class);
                startActivity(Intent.createChooser(i,"About us"));

                break;
            case R.id.nav_share:
                Toast.makeText(getApplicationContext(),"You click on share menu",Toast.LENGTH_SHORT).show();
                i=new Intent(
                        Intent.ACTION_SEND
                );
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"THE FANTASTIC KID LEARNING APP DOWNLOAD FROM BELOW LINK\n www.fcpune.project.apk");
                startActivity(Intent.createChooser(i,"Share via"));
                break;
            case R.id.nav_send:
                Toast.makeText(getApplicationContext(),"You click on feedback menu",Toast.LENGTH_SHORT).show();
                i=new Intent(Intent.ACTION_SEND);
                i.setType("text/html");
              //  i.setData(Uri.parse("mailto:"));
                String[] to={"bardeas496@gmail.com","dipakdhawade143@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL,to);
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback for your kid learning app");
                i.putExtra(Intent.EXTRA_TEXT,"Hi  \n");
                startActivity(Intent.createChooser(i,"Send Email"));
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    }
