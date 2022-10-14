package ads.view.recyclerview

import android.util.SparseArray
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * @author QiuJie
 */
class AdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val views = SparseArray<View>()

    fun <T : View?> getView(@IdRes id: Int): T? {
        if (id == View.NO_ID) {
            return null
        }
        var v = views[id]
        if (v == null) {
            v = itemView.findViewById(id)
        }
        return v as T
    }
}