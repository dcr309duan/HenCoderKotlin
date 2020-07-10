package com.example.core

/**
 * @author dcr
 * @date 2020/7/10  19:54
 */
interface BaseView<T> {
    fun getPresenter(): T
}