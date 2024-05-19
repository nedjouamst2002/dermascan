package com.example.onboardingscreens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.window.SplashScreen;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;


public class IntroActivity extends AppCompatActivity {
    protected ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make the activity on full screen
       requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
               WindowManager.LayoutParams.FLAG_FULLSCREEN);
          // when this activity is about to be launched, we need to check
          // if it is opened before or not

        if (restorePrefData()) {

            Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(mainActivity);
            finish();


        }



        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);

        // ini views
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_started);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);


        //fill list screen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("To DermaScan!", "Your personal skin health assistant.", R.drawable.welcome));
        mList.add(new ScreenItem("Early detection is vital.", "It can determine if a condition is easily treatable or escalates to a more serious level.\n With our app, you can catch issues early and seek treatment sooner.", R.drawable.hand_scan));
        mList.add(new ScreenItem("Scan your skin at home with ease.", "No need to wait for a doctor's appointment, we make it easier and faster for you.", R.drawable.scan_home));
        //setup viewpager

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);
        // setup tablelayout
        tabIndicator.setupWithViewPager(screenPager);

        // next button click listner
        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if(position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if(position == mList.size() - 1){ // when we reach to the last screen

                    // TODO : show the GETSTARTED button and hide the indicator and the next button
                    loadLastScreen();
                }
            }
        });

        // tablayout add change listner

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mList.size() - 1){

                    loadLastScreen();

                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        //Get started button click listner
        btnGetStarted.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // open MainActivity

                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
                // Save a boolean value to storage so next time when the user runs the app
                // we would know that he already checked the intro screen activity
                savePrefsData();
                finish();


            }
        });


    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;
    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.apply();

    }

    //show the GETSTARTED button and hide the indicator and the next button
    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        // TODO : ADD an animation to the getstarted button
        // setup animation
        btnGetStarted.setAnimation(btnAnim);

    }
}
