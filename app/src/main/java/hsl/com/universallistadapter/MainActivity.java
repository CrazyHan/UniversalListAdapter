package hsl.com.universallistadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsl.com.universallistadapter.adapter.UniversalListViewAdapter;
import hsl.com.universallistadapter.adapter.ViewHolder;
import hsl.com.universallistadapter.adapter.ViewHolderCreator;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<100;i++) {
            list.add(i);
        }
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new UniversalListViewAdapter(new ViewHolderCreator<MyViewHolder>() {
            @Override
            public MyViewHolder createViewHolder() {
                return new MyViewHolder();
            }
        },list));
    }

    class MyViewHolder implements ViewHolder<Integer> {
        TextView textView;
        @Override
        public View createView(Context context) {
            textView = new TextView(context);


            return textView;
        }

        @Override
        public void updateUI(Integer integer) {
            textView.setText(integer+"");
        }
    }
}
