package com.konflikgis.konflikgis;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView logoTV;
    private Typeface greatLakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        greatLakes = Typeface.createFromAsset(getAssets(), "fonts/GreatLakesNF.ttf");
        logoTV = (TextView) findViewById(R.id.logo_splash_tv);

        logoTV.setTypeface(greatLakes);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
