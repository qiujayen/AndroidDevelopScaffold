package ads.view.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author QiuJie
 */
class LinearSpaceItemDecoration(private val space: Float) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view)
        val layoutManager = parent.layoutManager
        if (layoutManager is LinearLayoutManager) {
            when (layoutManager.orientation) {
                RecyclerView.VERTICAL -> {
                    when (position) {
                        0 -> {
                            outRect.set(0, 0, 0, (space / 2).toInt())
                        }
                        parent.adapter!!.itemCount - 1 -> {
                            outRect.set(0, (space / 2).toInt(), 0, 0)
                        }
                        else -> {
                            outRect.set(0, (space / 2).toInt(), 0, (space / 2).toInt())
                        }
                    }

                }
                RecyclerView.HORIZONTAL -> {
                    when (position) {
                        0 -> {
                            outRect.set(0, 0, (space / 2).toInt(), 0)
                        }
                        parent.adapter!!.itemCount - 1 -> {
                            outRect.set((space / 2).toInt(), 0, 0, 0)
                        }
                        else -> {
                            outRect.set((space / 2).toInt(), 0, (space / 2).toInt(), 0)
                        }
                    }
                }
            }
        }
    }

}