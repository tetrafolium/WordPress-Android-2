package org.wordpress.android.ui.utils

import android.util.Base64
import org.wordpress.android.fluxc.network.HTTPAuthManager
import org.wordpress.android.fluxc.network.UserAgent
import org.wordpress.android.fluxc.network.rest.wpcom.auth.AccessToken
import org.wordpress.android.util.WPUrlUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationUtils
@Inject constructor(
    private val accessToken: AccessToken,
    private val httpAuthManager: HTTPAuthManager,
    private val userAgent: UserAgent
) {
    fun getAuthHeaders(url: String): Map<String, String> {
        val headers = mutableMapOf<String, String>()
        headers["User-Agent"] = userAgent.userAgent
        if (WPUrlUtils.safeToAddWordPressComAuthToken(url)) {
            if (accessToken.exists()) {
                headers["Authorization"] = "Bearer " + accessToken.get()
            }
        } else {
            // Check if we had HTTP Auth credentials for the root url
            val httpAuthModel = httpAuthManager.getHTTPAuthModel(url)
            if (httpAuthModel != null) {
                val creds = String.format("%s:%s", httpAuthModel.username, httpAuthModel.password)
                val auth = "Basic " + Base64.encodeToString(creds.toByteArray(), Base64.NO_WRAP)
                headers["Authorization"] = auth
            }
        }
        return headers
    }
}
