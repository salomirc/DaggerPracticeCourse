package com.belsoft.daggerpracticecourse.di;

import com.belsoft.daggerpracticecourse.AuthActivity;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Provides
    static String provideString() {
        return "blah blah ...";
    }
}
