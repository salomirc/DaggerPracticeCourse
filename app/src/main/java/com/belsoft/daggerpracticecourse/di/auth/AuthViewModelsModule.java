package com.belsoft.daggerpracticecourse.di.auth;

import androidx.lifecycle.ViewModel;

import com.belsoft.daggerpracticecourse.di.ViewModelKey;
import com.belsoft.daggerpracticecourse.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

      // How to map another ViewModel type i.e. AnotherViewModel.java
//    @Binds
//    @IntoMap
//    @ViewModelKey(AnotherViewModel.class)
//    public abstract ViewModel bindAuthViewModel(AnotherViewModel viewModel);

}
