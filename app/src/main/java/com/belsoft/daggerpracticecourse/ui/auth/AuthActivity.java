package com.belsoft.daggerpracticecourse.ui.auth;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.belsoft.daggerpracticecourse.R;
import com.belsoft.daggerpracticecourse.viewmodels.ViewModelProviderFactory;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

// Required to extend from DaggerAppCompatActivity if we use @ContributesAndroidInjector annotation
public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";
    private AuthViewModel viewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    Application applicationInjected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        viewModel = new ViewModelProvider(this, viewModelProviderFactory).get(AuthViewModel.class);

        setLogo();
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .into((ImageView) findViewById(R.id.login_logo));
    }
}