package com.awefulApps.ask8ball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.view.Window;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class Ask8Ball extends AppCompatActivity {

    private static final String[] responses = { "It is certain", "Reply hazy, try again", "As I see it, yes", "Don't count on it", "It is decidedly so"
                                                , "Ask again later", "Most likely", "My reply is no", "Without a doubt", "Better not tell you now"
                                                , "Outlook good", "My sources say no", "Yes – definitely", "Cannot predict now" , "Yes", "Outlook not so good"
                                                , "You may rely on it", "Concentrate and ask again", "Signs point to yes", "Very doubtful"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask8_ball);
        this.getSupportActionBar().hide();
        Random rand = new Random();
        int randomNum = rand.nextInt( responses.length );
        String response = responses[ randomNum ];
        TextView textView = findViewById( R.id.answer);
        textView.setText( response + " !" );

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3 * 1000);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdView ban1 = findViewById(R.id.ban1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        ban1.loadAd(adRequest);

    }
} 