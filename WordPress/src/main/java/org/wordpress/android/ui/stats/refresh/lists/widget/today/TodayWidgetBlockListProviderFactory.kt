package org.wordpress.android.ui.stats.refresh.lists.widget.today

import android.content.Context
import android.content.Intent
import javax.inject.Inject
import org.wordpress.android.WordPress
import org.wordpress.android.ui.stats.refresh.lists.widget.WidgetBlockListProvider

class TodayWidgetBlockListProviderFactory(val context: Context, val intent: Intent) {
    @Inject lateinit var viewModel: TodayWidgetBlockListViewModel

    init {
        (context.applicationContext as WordPress).component().inject(this)
    }

    fun build(): WidgetBlockListProvider {
        return WidgetBlockListProvider(context, viewModel, intent)
    }
}
