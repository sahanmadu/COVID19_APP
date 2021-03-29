package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int mySplashScreen=5000;

    Animation topAnim,bottomAnim;
    ImageView image;
    TextView text,text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottoma_animation);

        image=findViewById(R.id.imageView);
        text=findViewById(R.id.textView);
        text1=findViewById(R.id.textView3);


        image.setAnimation(topAnim);
        text.setAnimation(bottomAnim);
        text1.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent second=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(second);
                finish();
            }
        },mySplashScreen);
    }


}