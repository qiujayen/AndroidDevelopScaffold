package cn.ads.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

/**
 * @author QiuJie
 */
public abstract class AdsCommonListAdapter<T> extends ListAdapter<T,AdsCommonViewHolder> {

    protected AdsCommonListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    protected AdsCommonListAdapter(@NonNull AsyncDifferConfig<T> config) {
        super(config);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsCommonViewHolder holder, int position) {
        T item = getItem(position);
        if (item != null) {
            onBindViewHolder(holder, position, item);
        }
    }

    public abstract void onBindViewHolder(@NonNull AdsCommonViewHolder holder, int position, T item);

}
