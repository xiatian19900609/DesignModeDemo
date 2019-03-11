package xt.com.baselibrary.data.protocol

data class BaseResponseData<T>(val code: Int, val message: String, val data: T)