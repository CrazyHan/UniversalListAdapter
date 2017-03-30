package hsl.com.universallistadapter.adapter;

import android.content.Context;
import android.view.View;

/**
 * Created by hanshenglong on 16/03/2017.
 */

public interface ViewHolder<T> {

    View createView(Context context);

    void updateUI(T data);

}
