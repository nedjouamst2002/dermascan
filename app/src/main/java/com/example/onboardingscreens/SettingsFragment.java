package com.example.onboardingscreens;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SettingsFragment extends Fragment {

    Switch switcher;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        switcher = view.findViewById(R.id.switcher);

        sharedPreferences = getActivity().getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("night", false);

        if (nightMode) {
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            switcher.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nightMode = !nightMode;
                if (nightMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                }
                editor.apply();
                switcher.setChecked(nightMode);
            }
        });

        Button aboutAppButton = view.findViewById(R.id.about_app_button);
        aboutAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout optionsLayout = view.findViewById(R.id.options_layout);
                if (optionsLayout.getVisibility() == View.VISIBLE) {
                    optionsLayout.setVisibility(View.GONE);
                } else {
                    optionsLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        view.findViewById(R.id.option1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEnglishFragment();
            }
        });

        view.findViewById(R.id.option2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToArabicFragment();
            }
        });

        return view;
    }

    private void navigateToEnglishFragment() {
        EnglishFragment englishFragment = new EnglishFragment();
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, englishFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateToArabicFragment() {
        ArabicFragment arabicFragment = new ArabicFragment();
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, arabicFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
