package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public
class LanguageSelectionActivity extends AppCompatActivity {

    private Button mBtnEnglish;
    private Button mBtnHindi;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        mBtnEnglish = findViewById(R.id.btnEnglish);
        mBtnHindi = findViewById(R.id.btnHindi);

        mBtnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                Configuration config = getBaseContext().getResources().getConfiguration();
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                Intent profileintent = new Intent(LanguageSelectionActivity.this,CandidateDataProfileActivity.class);
                startActivity(profileintent);

            }
        });

        mBtnHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                Configuration config = getBaseContext().getResources().getConfiguration();
                Locale locale = new Locale("hi");
                Locale.setDefault(locale);
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                Intent profileintent = new Intent(LanguageSelectionActivity.this,CandidateDataProfileActivity.class);
                startActivity(profileintent);


            }
        });

    }
}