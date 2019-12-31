package com.chazo.personal.two.cleanarchitecturestudy

import com.chazo.personal.two.cleanarchitecturestudy.di.application.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class GlobalApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().application(this).build()


    override fun onCreate() {
        super.onCreate()
        setupRxJavaErrorHandler()
        setupTimber()
    }

    private fun setupRxJavaErrorHandler() {
//        RxJavaPlugins.setErrorHandler { e ->
//            var error = e
//            if (error is UndeliverableException) {
//                error = e.cause
//            }
////            if (error is IOException || error is SocketException) {
////                // fine, irrelevant network problem or API that throws on cancellation
////                return@setErrorHandler
////            }
////            if (error is InterruptedException) {
////                // fine, some blocking code was interrupted by a dispose call
////                return@setErrorHandler
////            }
//            if (error is NullPointerException || error is IllegalArgumentException) {
//                // that's likely a bug in the application
//                Thread.currentThread().uncaughtExceptionHandler
//                    .uncaughtException(Thread.currentThread(), error)
//                return@setErrorHandler
//            }
//            if (error is IllegalStateException) {
//                // that's a bug in RxJava or in a custom operator
//                Thread.currentThread().uncaughtExceptionHandler
//                    .uncaughtException(Thread.currentThread(), error)
//                return@setErrorHandler
//            }
//            Log.w("Undeliverable exception received, not sure what to do", error)
//        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}