package com.project.forecasttest.utils

import android.content.Context

class UserPreference(private val context: Context) : IUserPreference {

    override fun get(key: String): String? {
        val sharePref = context.getSharedPreferences(key, Context.MODE_PRIVATE)
        return sharePref.getString("json", null)
    }

    override fun save(key: String, content: String) {
        val sharePref = context.getSharedPreferences(key, Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        editor.putString("json", content)
        editor.putString("time", getCurrenutime().toString())
        editor.apply()
    }

    override fun remove(key: String) {
        val sharePref = context.getSharedPreferences(key, Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        editor.remove("json")
        editor.remove("time")
        editor.apply()
    }

    private fun getCurrenutime(): Long {
        return System.currentTimeMillis() / 1000
    }
}