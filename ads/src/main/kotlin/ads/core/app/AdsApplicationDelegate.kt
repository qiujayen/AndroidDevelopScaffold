package ads.core.app

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper

/**
 * @author QiuJie
 */
class AdsApplicationDelegate(application: Application, adaptive: AdsAutoSizeAdaptive) :
    ActivityLifecycleCallbacks, ComponentCallbacks {
    private val mAdaptive: AdsAutoSizeAdaptive
    private var mApplicationStatusCallback: ApplicationStatusCallback? = null
    private var activityCounter = 0
    private var isBackground = false

    init {
        application.registerActivityLifecycleCallbacks(this)
        mAdaptive = adaptive
        if (mAdaptive.isAdaptive()) {
            mAdaptive.adaptive()
            application.registerComponentCallbacks(this)
        }
    }

    fun setDefaultUncaughtExceptionHandler(handler: Thread.UncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(handler)
        Handler(Looper.getMainLooper()).post {
            //主线程异常拦截
            while (true) {
                try {
                    Looper.loop() //主线程的异常会从这里抛出
                } catch (e: Throwable) {
                    handler.uncaughtException(Looper.getMainLooper().thread, e)
                }
            }
        }
    }

    fun setApplicationStatusCallback(callback: ApplicationStatusCallback?) {
        mApplicationStatusCallback = callback
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        if (newConfig.fontScale > 0) {
            mAdaptive.adaptive()
        }
    }

    override fun onLowMemory() {}
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is AdsAutoSizeAdaptive) {
            val adaptive: AdsAutoSizeAdaptive = activity as AdsAutoSizeAdaptive
            if (adaptive.isAdaptive()) {
                adaptive.adaptive()
            }
        } else {
            if (mAdaptive.isAdaptive()) {
                mAdaptive.adaptive()
            }
        }
    }

    override fun onActivityStarted(activity: Activity) {
        activityCounter++
        if (isBackground) {
            isBackground = false
            if (mApplicationStatusCallback != null) {
                mApplicationStatusCallback!!.onApplicationEnterForeground()
            }
        }
    }

    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {
        activityCounter--
        if (activityCounter <= 0) {
            if (mApplicationStatusCallback != null) {
                isBackground = true
                mApplicationStatusCallback!!.onApplicationEnterBackground()
            }
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
    interface ApplicationStatusCallback {
        /**
         * 应用进入前台时
         */
        fun onApplicationEnterForeground()

        /**
         * 应用进入后台时
         */
        fun onApplicationEnterBackground()
    }
}