package com.belsoft.daggerpracticecourse.di;

import com.belsoft.daggerpracticecourse.di.auth.AuthModule;
import com.belsoft.daggerpracticecourse.di.auth.AuthScope;
import com.belsoft.daggerpracticecourse.di.auth.AuthViewModelsModule;
import com.belsoft.daggerpracticecourse.di.main.MainFragmentBuildersModule;
import com.belsoft.daggerpracticecourse.di.main.MainModule;
import com.belsoft.daggerpracticecourse.di.main.MainScope;
import com.belsoft.daggerpracticecourse.di.main.MainViewModelsModule;
import com.belsoft.daggerpracticecourse.ui.auth.AuthActivity;
import com.belsoft.daggerpracticecourse.ui.main.MainActivity;

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
    @AuthScope
    @ContributesAndroidInjector(
            modules = { AuthViewModelsModule.class, AuthModule.class }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = { MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class }
    )
    abstract MainActivity contributeMainActivity();
}
