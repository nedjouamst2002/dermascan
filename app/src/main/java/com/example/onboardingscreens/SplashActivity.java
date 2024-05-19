
package com.example.onboardingscreens;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class SplashActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Animation animationUptoDown;
    Animation animationDownToUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView = findViewById(R.id.txt_v);
        imageView = findViewById(R.id.image_view);

        // Load animations
        animationUptoDown = AnimationUtils.loadAnimation(this, R.anim.uptodownanim);
        animationDownToUp = AnimationUtils.loadAnimation(this, R.anim.downtotopanim);

        // Set animations to views
        imageView.setAnimation(animationUptoDown);
        textView.setAnimation(animationDownToUp);

        // Start activity after a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 4000);
    }
}

