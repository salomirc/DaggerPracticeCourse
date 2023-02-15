package com.belsoft.daggerpracticecourse.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.belsoft.daggerpracticecourse.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


// This module is for application level dependencies of the project
// i.e. Retrofit, Glide instance etc, anything that need to exist and do not change
// during the entire lifetime of the application
@Module
public class AppModule {

    // @Singleton annotation identifies a type that the injector only instantiates once, also the scope
    // of this type will be the same as AppComponent scope (entire lifetime of the application)
    // @Provides annotation is recommended to be used with a static method to make DI more efficient
    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }


    // Application instance is available because it was bind to the AppComponents
    // RequestOptions is available because RequestOptions exist as a dependency inside this module
    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide
                .with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static Drawable provideDrawable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.logo);
    }

}
