package org.wordpress.android.ui.uploads

import android.content.Context
import javax.inject.Inject
import org.wordpress.android.fluxc.model.PostModel

/**
 * An injectable class built on top of [UploadService].
 *
 * The main purpose of this is to provide testability for classes that use [UploadService]. This should never
 * contain any static methods.
 */
class UploadServiceFacade @Inject constructor() {
    fun uploadPost(context: Context, post: PostModel, trackAnalytics: Boolean) {
        val intent = UploadService.getRetryUploadServiceIntent(context, post, trackAnalytics)
        context.startService(intent)
    }

    fun isPostUploadingOrQueued(post: PostModel) = UploadService.isPostUploadingOrQueued(post)
}
