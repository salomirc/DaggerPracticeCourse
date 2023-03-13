package com.belsoft.daggerpracticecourse;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.belsoft.daggerpracticecourse.models.User;
import com.belsoft.daggerpracticecourse.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {

    private static final String TAG = "DaggerExample";

    // data
    private final MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager() {

    }

    public void authenticateWithId(final LiveData<AuthResource<User>> source) {
        cachedUser.setValue(AuthResource.loading(null));
        cachedUser.addSource(source, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                cachedUser.setValue(userAuthResource);
                cachedUser.removeSource(source);
            }
        });
    }

    public void logOut() {
        Log.d(TAG, "logOut: logging out...");
        cachedUser.setValue(AuthResource.logout());
    }


    public LiveData<AuthResource<User>> getAuthUser() {
        return cachedUser;
    }

}