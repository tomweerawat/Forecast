package com.project.forecasttest.utils

interface IUserPreference {
    fun get(key: String): String?
    fun save(key: String, content: String)
    fun remove(key: String)
}