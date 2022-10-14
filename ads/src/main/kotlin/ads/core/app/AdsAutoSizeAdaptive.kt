package ads.core.app

import android.util.DisplayMetrics

/**
 * @author QiuJie
 */
interface AdsAutoSizeAdaptive {
    /**
     * 是否开启适配
     */
    fun isAdaptive(): Boolean

    /**
     * @return 设计稿基准宽度
     */
    fun designDraftWidth(): Int

    fun getDisplayMetrics(): DisplayMetrics?


    fun adaptive() {
        val displayMetrics = getDisplayMetrics() ?: return
        val density = displayMetrics.widthPixels / designDraftWidth()
        val scaledDensity = density * (displayMetrics.scaledDensity / displayMetrics.density)
        val densityDpi = density * 160
        displayMetrics.density = density.toFloat()
        displayMetrics.scaledDensity = scaledDensity
        displayMetrics.densityDpi = densityDpi
    }
}