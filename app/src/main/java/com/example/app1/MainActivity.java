package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public
class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    Button mBtnStarted;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = findViewById(R.id.lottie);
        mBtnStarted = findViewById(R.id.btn_started);

        mBtnStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LanguageSelectionActivity.class));
            }
        });
    }
}