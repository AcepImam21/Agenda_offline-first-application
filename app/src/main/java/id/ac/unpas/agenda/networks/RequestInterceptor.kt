package id.ac.unpas.agenda.networks

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = chain.request()
            .newBuilder()
            .url(originalRequest.url)
            .build()
        Log.d("Request", request.toString())
        return chain.proceed(request)
    }
}