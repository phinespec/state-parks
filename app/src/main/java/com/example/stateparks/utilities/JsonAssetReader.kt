package com.example.stateparks.utilities

import android.content.Context
import com.google.gson.Gson
import timber.log.Timber
import java.io.IOException

object JsonAssetReader
{
    fun <T> readList(jsonFileName: String, context: Context, arrayType: Class<Array<T>>): List<T>
    {
        var list: List<T> = listOf()
        try
        {
            val jsonData: String = context.applicationContext.assets.open(jsonFileName)
                .bufferedReader().use { it.readText() }
            val typeList: Array<T> = Gson().fromJson(jsonData, arrayType)

            list = typeList.toList()
        } catch (exception: IOException)
        {
            Timber.e(exception)
        }

        return list
    }
}