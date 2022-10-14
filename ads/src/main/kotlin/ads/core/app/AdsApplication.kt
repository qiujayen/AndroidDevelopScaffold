package ads.core.app

import android.app.Application
import android.util.DisplayMetrics

/**
 * @author QiuJie
 */
abstract class AdsApplication : Application(),
    AdsApplicationDelegate.ApplicationStatusCallback, Thread.UncaughtExceptionHandler, AdsAutoSizeAdaptive {
    override fun onCreate() {
        super.onCreate()
        val applicationDelegate = AdsApplicationDelegate(this, this)
        applicationDelegate.setApplicationStatusCallback(this)
        applicationDelegate.setDefaultUncaughtExceptionHandler(this)
    }

    /**
     * 应用进入前台时
     */
    override fun onApplicationEnterForeground() {}

    /**
     * 应用进入后台时
     */
    override fun onApplicationEnterBackground() {}

    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     *
     * Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     * @param t the thread
     * @param e the exception
     */
    override fun uncaughtException(t: Thread, e: Throwable) {}
    override fun isAdaptive(): Boolean {
        return false
    }

    override fun designDraftWidth(): Int {
        return 0
    }

    override fun getDisplayMetrics(): DisplayMetrics? {
        return null
    }
}