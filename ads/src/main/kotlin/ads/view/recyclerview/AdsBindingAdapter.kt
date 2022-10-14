package ads.view.recyclerview

import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

/**
 * @author QiuJie
 */
abstract class AdsBindingAdapter<T, VB : ViewBinding> : ListAdapter<T, AdsBindingViewHolder<VB>> {
    protected constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback)
    protected constructor(config: AsyncDifferConfig<T>) : super(config)

    override fun onBindViewHolder(holder: AdsBindingViewHolder<VB>, position: Int) {
        getItem(position)?.apply { onBindViewHolder(holder, holder.binding, this) }
    }

    abstract fun onBindViewHolder(holder: AdsBindingViewHolder<VB>, binding: VB, item: T)
}