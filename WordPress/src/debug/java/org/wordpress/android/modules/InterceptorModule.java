package org.wordpress.android.modules;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Named;
import okhttp3.Interceptor;

@Module
public class InterceptorModule {
@Provides
@IntoSet
@Named("network-interceptors")
public Interceptor provideStethoInterceptor() {
	return new StethoInterceptor();
}
}
