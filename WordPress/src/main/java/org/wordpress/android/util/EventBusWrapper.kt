package org.wordpress.android.util

import dagger.Reusable
import javax.inject.Inject
import org.greenrobot.eventbus.EventBus

/**
 * Provides an interface for [org.greenrobot.eventbus.EventBus] which can be mocked and used in unit tests.
 */
@Reusable
class EventBusWrapper @Inject constructor() {
    fun register(subscriber: Any) {
        EventBus.getDefault().register(subscriber)
    }

    fun unregister(subscriber: Any) {
        EventBus.getDefault().unregister(subscriber)
    }
}
