package cn.ads.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;

/**
 * @author QiuJie
 */
public abstract class AdsBindingListAdapter<T, VB extends ViewBinding> extends ListAdapter<T, AdsBindingViewHolder<VB>> {


    protected AdsBindingListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    protected AdsBindingListAdapter(@NonNull AsyncDifferConfig<T> config) {
        super(config);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsBindingViewHolder<VB> holder, int position) {
        T item = getItem(position);
        if (item != null) {
            onBindViewHolder(holder, position, item);
        }
    }

    public abstract void onBindViewHolder(@NonNull AdsBindingViewHolder<VB> holder, int position, T item);

}
