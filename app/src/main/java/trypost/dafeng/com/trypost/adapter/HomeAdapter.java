package trypost.dafeng.com.trypost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.entity.Picture;

/**
 * Created by asus on 2017/3/25.
 */
public class HomeAdapter extends BaseAdapter {
    ArrayList<Picture> list;
    Context context;

    public ArrayList<Picture> getList() {
        return list;
    }

    public void setList(ArrayList<Picture> list) {
        this.list = list;
    }

    public HomeAdapter(Context context) {
        this.context = context;
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
        MyViewHolder myViewHolder;
        if (view==null){
            myViewHolder=new MyViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.home_item,null);
            myViewHolder.iv= (ImageView) view.findViewById(R.id.home_item_iv);
            myViewHolder.tv_photo= (TextView) view.findViewById(R.id.home_item_tv_name);
            myViewHolder.tv_number= (TextView) view.findViewById(R.id.home_item_tv_number);
            view.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) view.getTag();
        }
        myViewHolder.iv.setImageResource(list.get(i).getPhotoId());
        myViewHolder.tv_number.setText(""+list.get(i).getNumber());
        myViewHolder.tv_photo.setText(list.get(i).getName());
        return view;
    }

    class MyViewHolder{
        ImageView iv;
        TextView tv_photo,tv_number;
    }
}
