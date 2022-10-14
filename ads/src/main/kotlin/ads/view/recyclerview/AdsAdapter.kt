package ads.view.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * @author QiuJie
 */
abstract class AdsAdapter<T>(private val mList: List<T>) : RecyclerView.Adapter<AdsViewHolder>() {
    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        mList[position]?.apply { onBindViewHolder(holder, position, this) }
    }

    abstract fun onBindViewHolder(holder: AdsViewHolder, position: Int, item: T)
}