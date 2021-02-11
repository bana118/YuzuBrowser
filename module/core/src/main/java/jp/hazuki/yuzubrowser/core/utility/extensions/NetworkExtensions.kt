/*
 * Copyright (C) 2017-2021 Hazuki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.hazuki.yuzubrowser.core.utility.extensions

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

fun ConnectivityManager.isConnectedWifi(): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val capabilities = getNetworkCapabilities(activeNetwork)
        capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false
    } else {
        @Suppress("DEPRECATION")
        val info = activeNetworkInfo!!
        @Suppress("DEPRECATION")
        info.isConnected && info.type == ConnectivityManager.TYPE_WIFI
    }
}
