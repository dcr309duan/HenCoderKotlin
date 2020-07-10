package com.example.core.http

/**
 * @author dcr
 * @date 2020/7/10  19:53
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)
    fun onFailure(message: String?)
}