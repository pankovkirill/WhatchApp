package com.example.watchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.watchapp.model.StopwatchListOrchestrator
import com.example.watchapp.model.StopwatchState

class MainViewModel(
    private val stopwatchListOrchestrator: StopwatchListOrchestrator
) : ViewModel() {

    val liveData = stopwatchListOrchestrator.ticker.asLiveData()

    fun start() {
        stopwatchListOrchestrator.start()
    }

    fun pause() {
        stopwatchListOrchestrator.pause()
    }

    fun stop() {
        stopwatchListOrchestrator.stop()
    }
}