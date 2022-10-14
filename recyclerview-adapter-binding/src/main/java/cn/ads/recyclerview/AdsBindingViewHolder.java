package cn.ads.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * @author QiuJie
 */
public class AdsBindingViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {

    public AdsBindingViewHolder(VB binding) {
        super(binding.getRoot());
    }

}
