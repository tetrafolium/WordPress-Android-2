package org.wordpress.android.ui.news

import javax.inject.Inject
import javax.inject.Singleton
import org.wordpress.android.util.analytics.AnalyticsUtils

@Singleton
class NewsTracker @Inject constructor() {
    enum class NewsCardOrigin {
        READER
    }

    fun trackNewsCardShown(origin: NewsCardOrigin, version: Int) {
        AnalyticsUtils.trackNewsCardShown(origin.name.toLowerCase(), version)
    }

    fun trackNewsCardDismissed(origin: NewsCardOrigin, version: Int) {
        AnalyticsUtils.trackNewsCardDismissed(origin.name.toLowerCase(), version)
    }

    fun trackNewsCardExtendedInfoRequested(origin: NewsCardOrigin, version: Int) {
        AnalyticsUtils.trackNewsCardExtendedInfoRequested(origin.name.toLowerCase(), version)
    }
}
