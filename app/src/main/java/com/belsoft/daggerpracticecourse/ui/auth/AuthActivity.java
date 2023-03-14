package com.belsoft.daggerpracticecourse.ui.auth;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.belsoft.daggerpracticecourse.R;
import com.belsoft.daggerpracticecourse.models.User;
import com.belsoft.daggerpracticecourse.viewmodels.ViewModelProviderFactory;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

// Required to extend from DaggerAppCompatActivity if we use @ContributesAndroidInjector annotation
public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AuthActivity";
    private AuthViewModel viewModel;
    private EditText userId;
    private ProgressBar progressBar;

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

        userId = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);
        findViewById(R.id.login_button).setOnClickListener(this);
        setLogo();
        subscribeObservers();
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .into((ImageView) findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:{
                attemptLogin();
                break;
            }
        }
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        viewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
    }

    private void subscribeObservers() {
        viewModel.observeAuthState().observe(this, new Observer<AuthResource<User>>() {

            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING: {
                            showProgressBar(true);
                            break;
                        }
                        case AUTHENTICATED: {
                            showProgressBar(false);
                            assert userAuthResource.data != null;
                            Log.d(TAG, "onChanged: LOGIN SUCCESS:" + userAuthResource.data.getEmail());
                            break;
                        }
                        case ERROR: {
                            showProgressBar(false);
                            Toast.makeText(AuthActivity.this, userAuthResource.message + "\nDid you enter a number between 1 and 10?", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        case NOT_AUTHENTICATED: {
                            showProgressBar(false);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}