package cn.ads.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

/**
 * @author QiuJie
 */
public class CommonDiffItemCallback extends DiffUtil.ItemCallback<Object> {
    @Override
    public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        return Objects.equals(oldItem, newItem);
    }
}
