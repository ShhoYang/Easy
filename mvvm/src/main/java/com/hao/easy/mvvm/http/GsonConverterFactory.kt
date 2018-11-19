package com.hao.easy.mvvm.http

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import com.hao.easy.mvvm.model.HttpResult
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/*
 * @author Yang Shihao
 * @date 2018/11/19
 */
class GsonConverterFactory(val gson: Gson = Gson()) : Converter.Factory() {

    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): GsonResponseBodyConverter<*>? {
        val newType = object : ParameterizedType {
            override fun getActualTypeArguments(): Array<Type> {
                return arrayOf(type)
            }

            override fun getOwnerType(): Type? {
                return null
            }

            override fun getRawType(): Type {
                return HttpResult::class.java
            }
        }
        val adapter = gson.getAdapter(TypeToken.get(newType))
        return GsonResponseBodyConverter(adapter as TypeAdapter<HttpResult<*>>)
    }

    override fun requestBodyConverter(type: Type, parameterAnnotations: Array<Annotation>, methodAnnotations: Array<Annotation>, retrofit: Retrofit): GsonRequestBodyConverter<out Any> {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return GsonRequestBodyConverter(gson, adapter)
    }
}