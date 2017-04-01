package trypost.dafeng.com.trypost.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.activity.ReimburseItemActivity;
import trypost.dafeng.com.trypost.entity.Mine;
import trypost.dafeng.com.trypost.entity.Reimburse;

/**
 * Created by asus on 2017/3/27.
 */
public class ReimburseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    ArrayList<Integer> list,images;
    Context context;
    HashMap<Integer,Reimburse> hashMap;
    ReimburseBottomAdapter rba;
    String string;
    Mine mine;
    TextWatcher watcher;
    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public ReimburseAdapter(Context context) {
        this.context = context;
        images=new ArrayList<>();
        images.add(R.mipmap.add008);
        rba=new ReimburseBottomAdapter(context);
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reimburse_item_rl_budget:
                string="预算事项";
                break;
            case R.id.reimburse_item_rl_government:
                string="是否政府采购";
                break;
            case R.id.reimburse_item_rl_currency:
                string="币种";
                break;
            case R.id.reimburse_item_rl_detail:
                string="费用明细";
                break;
            case R.id.reimburse_head_rl_gathering:
                string="收款方";
                break;
            case R.id.reimburse_head_rl_lend:
                string="原借款";
                break;
            case R.id.reimburse_head_rl_use:
                string="引用合同";
                break;
            case R.id.apply_reimburse_tv_add:
                list.add(1);
                notifyDataSetChanged();
                return;
        }
        Intent intent=new Intent(context, ReimburseItemActivity.class);
        intent.putExtra("name",string);
        context.startActivity(intent);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            View view=LayoutInflater.from(context).inflate(R.layout.apply_reimburse_head,null);
            HeadViewHolder hvh=new HeadViewHolder(view);
            return hvh;
        }else if (viewType==1){
           View view = LayoutInflater.from(context).inflate(R.layout.apply_reimburse_item, null);
            ReimburseViewHolder rvh=new ReimburseViewHolder(view);
            return rvh;
        }else if (viewType==2){
            View view=LayoutInflater.from(context).inflate(R.layout.apply_reimburse_bottom,null);
            BottomViewHolder bvh=new BottomViewHolder(view);
            return bvh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReimburseViewHolder) {
            ((ReimburseViewHolder) holder).rl_budget.setOnClickListener(this);
            ((ReimburseViewHolder) holder).rl_currency.setOnClickListener(this);
            ((ReimburseViewHolder) holder).rl_government.setOnClickListener(this);
            ((ReimburseViewHolder) holder).rl_detail.setOnClickListener(this);
            if(mine!=null){
                ((ReimburseViewHolder) holder).et_much.setText(mine.getPrice()+"");
                ((ReimburseViewHolder) holder).et_rotate.setText("5%");
                ((ReimburseViewHolder) holder).et_tax.setText(mine.getPrice()*5/100+"");
            }
            watcher=new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String money=((ReimburseViewHolder) holder).et_much.getText().toString();
                    String rotate=((ReimburseViewHolder) holder).et_rotate.getText().toString();
                    ((ReimburseViewHolder) holder).et_tax.setText(percentageConversion(money)*percentageConversion(rotate)+"");
                   ((ReimburseViewHolder) holder).tv_subtotal.setText(percentageConversion(money)+percentageConversion(((ReimburseViewHolder) holder).et_tax.getText().toString())+"");
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            };
            ((ReimburseViewHolder) holder).et_much.addTextChangedListener(watcher);
            ((ReimburseViewHolder) holder).et_rotate.addTextChangedListener(watcher);
        }else if (holder instanceof BottomViewHolder){
            ((BottomViewHolder) holder).tv_add.setOnClickListener(this);
            ((BottomViewHolder) holder).tv_total.setText("12345");
            ((BottomViewHolder) holder).tv_big.setText("壹万贰仟叁佰肆拾伍元");
            rba.setImages(images);
            ((BottomViewHolder) holder).rcv.setAdapter(rba);
            rba.notifyDataSetChanged();
        }else if (holder instanceof HeadViewHolder){
            if(mine!=null){
                ((HeadViewHolder) holder).et_thing.setText(mine.getThing());
            }
            ((HeadViewHolder) holder).rl_use.setOnClickListener(this);
            ((HeadViewHolder) holder).rl_lend.setOnClickListener(this);
            ((HeadViewHolder) holder).rl_gathering.setOnClickListener(this);
        }
    }

    /**
     * 百分比或者字符串转换成数字
     * @param string
     * @return
     */
    public float percentageConversion(String string){
        if (string.length()==0){
            return 0;
        }
        float denominator=1;//定义一个分母，如果没有百分号，则分母为1
       if (string.contains("%")){
           denominator=100;
           string=string.replace("%","");
       }
        int point=string.indexOf(".");//获取点的位置，如果没有则返回-1
        if (point==-1){
            return Integer.parseInt(string)/denominator;
        }
        String ahead=string.substring(0,point);
        String before=string.substring(point+1);
        int head=Integer.parseInt(ahead);
        int fore=0;
        if (before.length()!=0){
            fore=Integer.parseInt(before);
        }
        int x=before.length();//计算小数点后面的位数，如0.0009,则为四位
        float y=1;
        for (int i = 0; i <x ; i++) {
            y*=10;
        }
        float result=(head+fore/y)/denominator;
        return result;
    }


    @Override
    public int getItemCount() {
        return list.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==list.size()+1){
            return 2;
        }
        return 1;
    }

    class ReimburseViewHolder extends RecyclerView.ViewHolder{
        TextView tv_subtotal;
        EditText et_rotate,et_tax,et_much;
        RelativeLayout rl_government,rl_detail,rl_currency,rl_budget;
        public ReimburseViewHolder(View itemView) {
            super(itemView);
            et_much = (EditText) itemView.findViewById(R.id.reimburse_item_et_much);
            et_rotate = (EditText) itemView.findViewById(R.id.reimburse_item_et_add_rotate);
            et_tax = (EditText) itemView.findViewById(R.id.reimburse_item_et_add_tax);
            rl_budget= (RelativeLayout) itemView.findViewById(R.id.reimburse_item_rl_budget);
            rl_currency= (RelativeLayout) itemView.findViewById(R.id.reimburse_item_rl_currency);
            rl_detail= (RelativeLayout) itemView.findViewById(R.id.reimburse_item_rl_detail);
            rl_government= (RelativeLayout) itemView.findViewById(R.id.reimburse_item_rl_government);
            tv_subtotal= (TextView) itemView.findViewById(R.id.reimburse_item_et_subtotal);
        }
    }
    class BottomViewHolder extends RecyclerView.ViewHolder{
        TextView tv_total,tv_big,tv_add,tv_save,tv_commit;
        GridView rcv;
        EditText et_remark;
        public BottomViewHolder(View itemView) {
            super(itemView);
            tv_total= (TextView) itemView.findViewById(R.id.apply_reimburse_tv_total);
            tv_big= (TextView) itemView.findViewById(R.id.apply_reimburse_tv_big);
            tv_add= (TextView) itemView.findViewById(R.id.apply_reimburse_tv_add);
            tv_save= (TextView) itemView.findViewById(R.id.apply_reimburse_tv_save);
            tv_commit= (TextView) itemView.findViewById(R.id.apply_reimburse_tv_commit);
            et_remark= (EditText) itemView.findViewById(R.id.reimburse_bottom_et_remark);
            rcv= (GridView) itemView.findViewById(R.id.bottom_rcv);
        }
    }

    class HeadViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout rl_lend,rl_use,rl_gathering;
        CheckBox cb_ticket,cb_no;
        EditText et_thing;
        TextView spr_use,spr_lend,spr_gathering;
        public HeadViewHolder(View itemView) {
            super(itemView);
            spr_gathering= (TextView) itemView.findViewById(R.id.apply_reimburse_spr_gathering);
            spr_lend= (TextView) itemView.findViewById(R.id.apply_reimburse_spr_lend);
            spr_use= (TextView) itemView.findViewById(R.id.apply_reimburse_spr_use);
            et_thing= (EditText) itemView.findViewById(R.id.apply_reimburse_et_thing);
            cb_no= (CheckBox) itemView.findViewById(R.id.apply_reimburse_cb_no);
            cb_ticket= (CheckBox) itemView.findViewById(R.id.apply_reimburse_cb_ticket);
            rl_gathering= (RelativeLayout) itemView.findViewById(R.id.reimburse_head_rl_gathering);
            rl_lend= (RelativeLayout) itemView.findViewById(R.id.reimburse_head_rl_lend);
            rl_use= (RelativeLayout) itemView.findViewById(R.id.reimburse_head_rl_use);
        }
    }
}
