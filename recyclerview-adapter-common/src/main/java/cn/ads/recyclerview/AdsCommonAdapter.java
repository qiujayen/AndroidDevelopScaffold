package cn.ads.recyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author QiuJie
 */
public abstract class AdsCommonAdapter<T> extends RecyclerView.Adapter<AdsCommonViewHolder> {

    @Nullable
    private List<T> mList;

    public AdsCommonAdapter() {
    }

    public AdsCommonAdapter(@Nullable List<T> list) {
        this.mList = list;
    }

    @Override
    public void onBindViewHolder(@NonNull AdsCommonViewHolder holder, int position) {
        T item = getItem(position);
        if (item != null) {
            onBindViewHolder(holder, position, item);
        }
    }

    public abstract void onBindViewHolder(@NonNull AdsCommonViewHolder holder, int position, T item);

    public void submitList(@Nullable final List<T> newList) {
        this.mList = newList;
    }

    public List<T> getCurrentList() {
        return mList;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    protected T getItem(int position) {
        if (mList != null) {
            return mList.get(position);
        }
        return null;
    }
}
