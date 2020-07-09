package org.wordpress.android.modules;

import dagger.Module;
import dagger.Provides;
import org.wordpress.android.fluxc.store.AccountStore;
import org.wordpress.android.fluxc.store.SiteStore;
import org.wordpress.android.login.LoginAnalyticsListener;
import org.wordpress.android.ui.accounts.login.LoginAnalyticsTracker;

@Module
public class LoginAnalyticsModule {
  @Provides
  public LoginAnalyticsListener
  provideAnalyticsListener(AccountStore accountStore, SiteStore siteStore) {
    return new LoginAnalyticsTracker(accountStore, siteStore);
  }
}
