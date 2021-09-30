package com.belsoft.daggerpracticecourse;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

// Required to extend from DaggerAppCompatActivity if we use @ContributesAndroidInjector annotation
public class AuthActivity extends DaggerAppCompatActivity {

    private final String TAG = AuthActivity.class.getSimpleName();

    @Inject
    String abc;

    @Inject
    boolean isAppNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Log.d(TAG, "onCreate: " + abc);
        Log.d(TAG, "onCreate: is app null? " + isAppNull);
    }
}