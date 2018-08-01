package com.konflikgis.konflikgis;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView logoTV;
    private Typeface greatLakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        greatLakes = Typeface.createFromAsset(getAssets(), "fonts/GreatLakesNF.ttf");
        logoTV = (TextView) findViewById(R.id.logo_tentang_tv);

        logoTV.setTypeface(greatLakes);
    }
}
