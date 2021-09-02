package com.belsoft.daggerpracticecourse;

import android.os.Bundle;
import android.util.Log;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

public class AuthActivity extends DaggerAppCompatActivity {

    private final String TAG = AuthActivity.class.getSimpleName();

    @Inject
    String abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Log.d(TAG, abc);
    }
}