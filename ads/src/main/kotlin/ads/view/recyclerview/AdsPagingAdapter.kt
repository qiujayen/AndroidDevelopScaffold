package ads.view.recyclerview

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author QiuJie
 */
abstract class AdsPagingAdapter<T : Any, VB : ViewBinding> :
    PagingDataAdapter<T, AdsBindingViewHolder<VB>> {

    constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback)

    constructor(
        diffCallback: DiffUtil.ItemCallback<T>,
        mainDispatcher: CoroutineDispatcher
    ) : super(diffCallback, mainDispatcher)

    constructor(
        diffCallback: DiffUtil.ItemCallback<T>,
        mainDispatcher: CoroutineDispatcher,
        workerDispatcher: CoroutineDispatcher
    ) : super(diffCallback, mainDispatcher, workerDispatcher)

    override fun onBindViewHolder(holder: AdsBindingViewHolder<VB>, position: Int) {
        getItem(position)?.apply { onBindViewHolder(holder, holder.binding, this) }
    }

    abstract fun onBindViewHolder(holder: AdsBindingViewHolder<VB>, binding: VB, item: T)
}