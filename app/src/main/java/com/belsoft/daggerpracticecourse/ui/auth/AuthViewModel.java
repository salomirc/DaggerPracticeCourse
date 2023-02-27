package com.belsoft.daggerpracticecourse.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.belsoft.daggerpracticecourse.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: ViewModel is working!");
        if (authApi == null) {
            Log.d(TAG, "AuthViewModel: auth api is NULL");
        } else {
            Log.d(TAG, "AuthViewModel: auth api is NOT NULL");
        }
    }
}
