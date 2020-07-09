package org.wordpress.android.ui.stats.refresh.lists.widget.alltime

import javax.inject.Inject
import org.wordpress.android.modules.AppComponent
import org.wordpress.android.ui.stats.refresh.lists.widget.StatsWidget
import org.wordpress.android.ui.stats.refresh.lists.widget.WidgetUpdater

class StatsAllTimeWidget : StatsWidget() {
    @Inject lateinit var allTimeWidgetUpdater: AllTimeWidgetUpdater
    override val widgetUpdater: WidgetUpdater
        get() = allTimeWidgetUpdater

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }
}
