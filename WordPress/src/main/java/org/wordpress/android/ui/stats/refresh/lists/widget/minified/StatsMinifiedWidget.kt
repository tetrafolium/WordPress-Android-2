package org.wordpress.android.ui.stats.refresh.lists.widget.minified

import javax.inject.Inject
import org.wordpress.android.modules.AppComponent
import org.wordpress.android.ui.stats.refresh.lists.widget.StatsWidget
import org.wordpress.android.ui.stats.refresh.lists.widget.WidgetUpdater

class StatsMinifiedWidget : StatsWidget() {
    @Inject lateinit var minifiedWidgetUpdater: MinifiedWidgetUpdater
    override val widgetUpdater: WidgetUpdater
        get() = minifiedWidgetUpdater

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }
}
