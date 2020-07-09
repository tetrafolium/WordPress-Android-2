package org.wordpress.android.viewmodel

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton
import org.wordpress.android.util.LocaleManager

@Singleton
class ContextProvider
@Inject constructor(private var context: Context) {
    fun refreshContext() {
        this.context = LocaleManager.setLocale(this.context)
    }

    fun getContext(): Context = context
}
