package com.belsoft.daggerpracticecourse.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;


// This module is for application level dependencies of the project
// i.e. Retrofit, Glide instance etc, anything that need to exist and do not change
// during the entire lifetime of the application
@Module
public class AppModule {

    // @Provides annotation is recommended to be used with a static method to make DI more efficient
    @Provides
    static String provideString() {
        return "blah blah ...";
    }

    // Application instance is available because it was bind to the AppComponents
    @Provides
    static boolean getApp(Application application) {
        return application == null;
    }


    // String dependencies is available because String exist as a dependency inside this module
    @Provides
    static int someInt(String string) {
        if (string.equals("this is a test string")) {
            return 1;
        } else {
            return 0;
        }
    }
}
