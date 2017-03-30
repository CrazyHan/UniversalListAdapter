package hsl.com.universallistadapter.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanshenglong on 19/03/2017.
 */

public class UniversalListViewAdapter<T> extends BaseAdapter {
    List<T> datas = new ArrayList<>();
    private ViewHolderCreator creator;

    public UniversalListViewAdapter(ViewHolderCreator creator,List<T> datas) {
        this.datas = datas;
        this.creator = creator;

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder<T> holder = null;
        if (view == null) {
            holder = (ViewHolder<T>) creator.createViewHolder();
            view = holder.createView(viewGroup.getContext());
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        if (datas != null && holder != null) {
            holder.updateUI(datas.get(i));
        }

        return view;
    }
}
