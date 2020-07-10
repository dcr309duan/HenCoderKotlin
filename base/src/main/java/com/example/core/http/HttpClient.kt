package com.example.core.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 * @author dcr
 * @date 2020/7/10  19:39
 */
object HttpClient : OkHttpClient() {
    private val gson = Gson()

    private fun <T> convert(json: String?, type: Type): T {
        return gson.fromJson(json, type)
    }

    operator fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>) {
        val request = Request.Builder()
                .url("https://api.hencoder.com/$path")
                .build()
        val call = HttpClient.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) = when (response.code()) {
                in 200..299 -> entityCallback.onSuccess(convert(response.body()!!.string(), type))
                in 400..499 -> entityCallback.onFailure("客户端错误")
                in 500..599 -> entityCallback.onFailure("服务器错误")
                else -> entityCallback.onFailure("未知错误")
            }
        })
    }
}