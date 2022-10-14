package ads.view.recyclerview

import androidx.recyclerview.widget.DiffUtil

/**
 * @author QiuJie
 */
class StringDiffItemCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}