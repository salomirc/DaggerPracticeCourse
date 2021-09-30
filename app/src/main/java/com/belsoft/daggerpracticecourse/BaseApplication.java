package com.belsoft.daggerpracticecourse;

import com.belsoft.daggerpracticecourse.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        // DaggerAppComponent is a Dagger generated implementation of the declared interface AppComponent
        // and is available for intellisense after making a build (aka Make Project Ctr + F9)
        return DaggerAppComponent.builder().application(this).build();
    }
}
