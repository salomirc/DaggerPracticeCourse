package com.belsoft.daggerpracticecourse.di.main;

import com.belsoft.daggerpracticecourse.ui.main.posts.PostsFragment;
import com.belsoft.daggerpracticecourse.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostFragment();

}
