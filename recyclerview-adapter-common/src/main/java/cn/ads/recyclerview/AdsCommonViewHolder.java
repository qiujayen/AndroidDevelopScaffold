package cn.ads.recyclerview;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author QiuJie
 */
public class AdsCommonViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views = new SparseArray<>();

    public AdsCommonViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public <T extends View> T getView(@IdRes int id) {
        if (id == View.NO_ID) {
            return null;
        }
        View v = views.get(id);
        if (v == null) {
            v = itemView.findViewById(id);
        }
        return (T) v;
    }
}