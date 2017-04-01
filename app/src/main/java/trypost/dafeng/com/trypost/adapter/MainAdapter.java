package trypost.dafeng.com.trypost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;

/**
 * Created by asus on 2017/3/25.
 */
public class MainAdapter extends BaseAdapter {
    ArrayList<String> strings;
    Context context;

    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
    }

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view==null){
           view= LayoutInflater.from(context).inflate(R.layout.main_item,null);
            textView= (TextView) view.findViewById(R.id.main_item_tv);
            view.setTag(textView);
        }else {
            textView= (TextView) view.getTag();
        }
        textView.setText(strings.get(i));
        return view;
    }
}
