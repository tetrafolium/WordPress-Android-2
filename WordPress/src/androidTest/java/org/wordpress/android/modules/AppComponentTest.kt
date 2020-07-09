package org.wordpress.android.modules

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import org.wordpress.android.fluxc.module.DebugOkHttpClientModule
import org.wordpress.android.fluxc.module.ReleaseBaseModule
import org.wordpress.android.fluxc.module.ReleaseNetworkModule
import org.wordpress.android.fluxc.module.ReleaseToolsModule
import org.wordpress.android.login.di.LoginFragmentModule
import org.wordpress.android.login.di.LoginServiceModule
import org.wordpress.android.ui.stats.refresh.StatsModule

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AppConfigModule::class,
    ReleaseBaseModule::class,
    DebugOkHttpClientModule::class,
    InterceptorModuleTest::class,
    ReleaseNetworkModule::class,
    LegacyModule::class,
    ReleaseToolsModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    StatsModule::class,
    // Login flow library
    LoginAnalyticsModule::class,
    LoginFragmentModule::class,
    LoginServiceModule::class,
    SupportModule::class,
    ThreadModule::class])
interface AppComponentTest : AppComponent {
    @Component.Builder
    interface Builder : AppComponent.Builder {
        @BindsInstance
        override fun application(application: Application): AppComponentTest.Builder

        override fun build(): AppComponentTest
    }
}
