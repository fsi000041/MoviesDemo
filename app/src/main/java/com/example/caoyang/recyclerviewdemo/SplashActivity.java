package com.example.caoyang.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.lemon.view.Action;


public class SplashActivity extends AppCompatActivity {


    @Bind(R.id.iv_picture)
    ImageView ivPicture;
    @Bind(R.id.tv_jump)
    CountdownView mCountdownView;
    @Bind(R.id.iv_default)
    ImageView ivDefault;
    @Bind(R.id.tv_brightness)
    TextView tvBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        mCountdownView.setText("跳转");
        mCountdownView.setTime(5000);
        mCountdownView.star();

        mCountdownView.setOnFinishAction(new Action() {
            @Override
            public void onAction() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mCountdownView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tvBrightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}




