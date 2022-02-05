package com.example.watchapp.di

import com.example.watchapp.model.*
import com.example.watchapp.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val appModule = module {


    factory<TimestampProvider> {
        object : TimestampProvider {
            override fun getMilliseconds(): Long {
                return System.currentTimeMillis()
            }
        }
    }

    factory { ElapsedTimeCalculator(get()) }

    factory { StopwatchStateCalculator(get(), get()) }

    factory { TimestampMillisecondsFormatter() }

    factory { StopwatchStateHolder(get(), get(), get()) }

    factory {
        StopwatchListOrchestrator(
            get(), CoroutineScope(
                Dispatchers.Main
                        + SupervisorJob()
            )
        )
    }

    viewModel { MainViewModel(get()) }
}