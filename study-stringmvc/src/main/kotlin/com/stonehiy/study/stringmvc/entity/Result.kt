package com.stonehiy.study.stringmvc.entity

import java.io.Serializable

class Result<T> private constructor() : Serializable {

    var code: Int = 0
    var message: String = ""
    var data: T? = null
    var success: Boolean = false

    companion object {

        @JvmStatic
        fun <T> onBuilder(c: Int, m: String, d: T?, s: Boolean): Result<T> {
            return Result<T>().apply {
                code = c
                message = m
                data = d
                success = s
            }
        }

        @JvmStatic
        fun <T> onSuccess(d: T): Result<T> {
            return onBuilder(Error.ON_SUCCESS.code, Error.ON_SUCCESS.msg, d, true)
        }

        @JvmStatic
        fun <T> onSuccess(error: Error, d: T): Result<T> {
            return onBuilder(error.code, error.msg, d, true)
        }


        @JvmStatic
        fun <T> onFail(error: Error): Result<T> {
            return onBuilder(error.code, error.msg, null, false)
        }

        @JvmStatic
        fun <T> onFail(error: Error, d: T?): Result<T> {
            return onBuilder(error.code, error.msg, d, false)
        }
    }


}