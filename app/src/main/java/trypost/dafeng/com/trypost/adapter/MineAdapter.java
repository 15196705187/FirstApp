package trypost.dafeng.com.trypost.adapter;

import android.content.Context;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.entity.Mine;

/**
 * Created by asus on 2017/3/26.
 */
public class MineAdapter extends BaseAdapter {
    Context context;
    ArrayList<Mine> list;

    public ArrayList<Mine> getList() {
        return list;
    }

    public void setList(ArrayList<Mine> list) {
        this.list = list;
    }

    public MineAdapter(Context context) {
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
        MineViewHolder mineViewHolder;
        if (view==null){
            mineViewHolder=new MineViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.mine_item,null);
            mineViewHolder.tv_name= (TextView) view.findViewById(R.id.mine_item_tv_name);
            mineViewHolder.tv_price= (TextView) view.findViewById(R.id.mine_item_tv_money);
            mineViewHolder.tv_leader= (TextView) view.findViewById(R.id.mine_item_tv_leader);
            mineViewHolder.tv_time= (TextView) view.findViewById(R.id.mine_item_tv_time);
            mineViewHolder.tv_jine= (TextView) view.findViewById(R.id.mine_item_tv_jine);
            mineViewHolder.tv_thing= (TextView) view.findViewById(R.id.mine_item_tv_thing);
            mineViewHolder.tv_type= (TextView) view.findViewById(R.id.mine_item_tv_type);
            mineViewHolder.iv_lead= (ImageView) view.findViewById(R.id.mine_item_iv_leader);
            mineViewHolder.tv_price_time= (TextView) view.findViewById(R.id.mine_item_tv_price);
            view.setTag(mineViewHolder);
        }else {
            mineViewHolder= (MineViewHolder) view.getTag();
        }
        mineViewHolder.tv_type.setText(list.get(i).getType()+" ");
        mineViewHolder.tv_name.setText(list.get(i).getName());
        TextPaint text=mineViewHolder.tv_name.getPaint();//设置字体为粗体，在XML里面通过textStyle并不能将中文字设置成粗体
        text.setFakeBoldText(true);
        mineViewHolder.tv_time.setText(list.get(i).getTime());
        mineViewHolder.tv_thing.setText(list.get(i).getThing());
        TextPaint paint=mineViewHolder.tv_jine.getPaint();
        paint.setFakeBoldText(true);
        mineViewHolder.tv_leader.setText(list.get(i).getLeader());
        TextPaint textPaint=mineViewHolder.tv_leader.getPaint();
        textPaint.setFakeBoldText(true);
        mineViewHolder.iv_lead.setImageResource(R.mipmap.lead01);
       mineViewHolder.tv_price_time.setText(list.get(i).getNextStep());//时间和财务已经对换，在构造函数也对换过了
        /**
         * 此处需要对float型的数值做相应的操作
         * 从小数点往左，每隔三位数加一个‘
         */
        String temp="";
        double money=list.get(i).getPrice();//1453.9
        long integ= (long) money;//1453
        String all=list.get(i).getPrice()+"";//9
        String number=integ+"";
        String floa=all.substring(number.length())+"";
        StringBuffer str;
        if (number.length()>3){
            str=new StringBuffer();
            ArrayList<Integer> inters=new ArrayList<>();
            ArrayList<String> mid=new ArrayList<>();
            char[] chars=number.toCharArray();//1,4,5,3
            for (int j = chars.length-1; j >=0 ; j--) {
               inters.add((int) chars[j]-48);//3,5,4,1
            }
            for (int x = 0; x <inters.size() ; x++) {
                mid.add(inters.get(x)+"");
                if (x==(inters.size()-1)){
                    break;
                }
                if ((x+1)%3==0){
                    mid.add(",");//3,5,4,',1
                }
            }
            for (int t = mid.size()-1; t >=0 ; t--) {
                str.append(mid.get(t));
            }
            temp=str.toString()+floa;
        }else {
            temp=list.get(i).getPrice()+"";
        }
        mineViewHolder.tv_price.setText("¥"+temp);
        return view;
    }
    class MineViewHolder{
        TextView tv_name,tv_price,tv_leader,tv_time,tv_thing,tv_type,tv_jine,tv_price_time;//此处由于布局的内容修改，所以tv_time为财务，而最后这个则为时间
        ImageView iv_lead;
    }
}
