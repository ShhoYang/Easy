package com.hao.easy.mvvm.http

import android.text.TextUtils
import com.google.gson.TypeAdapter
import com.hao.easy.mvvm.model.HttpResult
import okhttp3.ResponseBody
import retrofit2.Converter

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */
class GsonResponseBodyConverter<T>(val typeAdapter: TypeAdapter<HttpResult<T>>) : Converter<ResponseBody, T> {
    override fun convert(value: ResponseBody): T? {
        try {
            var string = value.string()
            var httpResult: HttpResult<T>? = null
            if (!TextUtils.isEmpty(string)) {
                httpResult = typeAdapter.fromJson(string)
            }
            return httpResult?.data
        } catch (e: Exception) {

        } finally {
            value.close()
        }
        return null
    }
}