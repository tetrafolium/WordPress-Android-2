package org.wordpress.android.login.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import org.wordpress.android.login.LoginWpcomService;

@Module
public abstract class LoginServiceModule {
@ContributesAndroidInjector abstract LoginWpcomService loginWpcomService();
}
