package com.belsoft.daggerpracticecourse.di;

import com.belsoft.daggerpracticecourse.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

// Required to be an abstract class if we use @ContributesAndroidInjector annotation
// This module is registering Activities that are specified
// as a potential client (so it make possible to be injected with dependencies)
@Module
public abstract class ActivityBuildersModule {


    // Required to be an abstract method if we use @ContributesAndroidInjector annotation
    // This method declaration is specifying the AuthActivity as a potential client
    // and it can be now injected with dependencies
    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();
}
