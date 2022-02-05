package com.example.watchapp.model

interface TimestampProvider {
    fun getMilliseconds(): Long
}