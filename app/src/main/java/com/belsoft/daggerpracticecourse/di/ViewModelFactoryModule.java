package com.belsoft.daggerpracticecourse.di;

import androidx.lifecycle.ViewModelProvider;

import com.belsoft.daggerpracticecourse.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);
}
