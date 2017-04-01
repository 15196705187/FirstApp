package trypost.dafeng.com.trypost.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;

/**
 * Created by asus on 2017/3/28.
 */
public class ReimburseBottomAdapter extends BaseAdapter {
    ArrayList<Integer> images;
    Context context;

    public ReimburseBottomAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }


    @Override
    public int getCount() {
        return images.size();
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
        ImageView imageView;
        if (view==null){
            view=LayoutInflater.from(context).inflate(R.layout.reimburse_bottom_item,null);
            imageView= (ImageView) view.findViewById(R.id.bottom_item_iv);
            view.setTag(imageView);
        }else {
            imageView= (ImageView) view.getTag();
        }
        imageView.setImageResource(images.get(i));
        return view;
    }
}
