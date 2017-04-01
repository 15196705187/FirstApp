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
 * Created by asus on 2017/3/29.
 */
public class ReimburseItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> list;

    public ReimburseItemAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
            view= LayoutInflater.from(context).inflate(R.layout.reimburse_item_item,null);
            textView= (TextView) view.findViewById(R.id.reim_item_item_tv);
            view.setTag(textView);
        }else {
            textView= (TextView) view.getTag();
        }
        textView.setText(list.get(i));
        return view;
    }
}
