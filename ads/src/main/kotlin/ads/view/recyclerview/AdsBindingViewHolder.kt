package ads.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author QiuJie
 */
class AdsBindingViewHolder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)