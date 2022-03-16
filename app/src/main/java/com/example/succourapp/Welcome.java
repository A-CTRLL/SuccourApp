package com.example.succourapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle saveInstancesState){
        super.onCreate(saveInstancesState);
        setContentView(R.layout.welcome);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        anaEkranaGec();


    }

    private void anaEkranaGec() {
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.myanin);
        imageView=findViewById(R.id.succour_logo);
        anim.reset();
        imageView.clearAnimation();
        imageView.startAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);

                Welcome.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
