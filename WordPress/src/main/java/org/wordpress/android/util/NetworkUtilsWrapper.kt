package org.wordpress.android.util

import dagger.Reusable
import javax.inject.Inject
import org.wordpress.android.WordPress

@Reusable
class NetworkUtilsWrapper @Inject constructor() {
    /**
     * Returns true if a network connection is available.
     */
    fun isNetworkAvailable() = NetworkUtils.isNetworkAvailable(WordPress.getContext())
}
