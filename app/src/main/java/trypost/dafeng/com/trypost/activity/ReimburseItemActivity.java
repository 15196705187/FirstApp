package trypost.dafeng.com.trypost.activity;

import android.content.Intent;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.adapter.ReimburseItemAdapter;
import trypost.dafeng.com.trypost.base.MyActivity;

/**
 * Created by asus on 2017/3/28.
 */
public class ReimburseItemActivity extends MyActivity {
    View view;
    TextView tv_head,tv_name,tv_search;
    ImageView iv_back;
    EditText et_in;
    ListView lv;
    String string;
    ArrayList<String> lends,details,governments,budgets,gatherings,uses,currency,mids;
    ReimburseItemAdapter ria;
    @Override
    public void initial() {
        setContentView(R.layout.activity_reimburse_item);
        view=findViewById(R.id.reiburse_item_head);
        tv_head= (TextView) view.findViewById(R.id.title_tv_center);
        iv_back= (ImageView) view.findViewById(R.id.title_iv);
        lv= (ListView) findViewById(R.id.reimburse_item_lv);
        tv_name= (TextView) findViewById(R.id.reimburse_item_tv_name);
        et_in= (EditText) findViewById(R.id.reimburse_item_et_search);
        tv_search= (TextView) findViewById(R.id.reimburse_item_tv_search);
        ria=new ReimburseItemAdapter(this);
    }

    @Override
    public void operator() {
        Intent intent=getIntent();
        if (intent!=null){
            string=intent.getStringExtra("name");
        }
        switch (string){
            case "是否政府采购":
                mids=governments;
                break;
            case "原借款":
                mids=lends;
                break;
            case "预算事项":
                mids=budgets;
                break;
            case "费用明细":
                mids=details;
                break;
            case "引用合同":
                mids=uses;
                break;
            case "收款方":
                mids=gatherings;
                break;
            case "币种":
                mids=currency;
                break;
        }
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strings=et_in.getText().toString();
                ArrayList<String> temp=new ArrayList<String>();
                for (int i = 0; i <mids.size() ; i++) {
                    Log.i("msgs","xxxxx");
                    if (mids.get(i).contains(strings)){
                        temp.add(mids.get(i));
                    }
                }
                ria.setList(temp);
                ria.notifyDataSetChanged();
            }
        });
        if (string.equals("是否政府采购")){
            et_in.setVisibility(View.GONE);
            tv_search.setVisibility(View.GONE);
        }
        tv_name.setText(string);
        TextPaint textPaint=tv_name.getPaint();
        textPaint.setFakeBoldText(true);
        ria.setList(mids);
        lv.setAdapter(ria);
        ria.notifyDataSetChanged();
    }

    @Override
    public void addData() {
        mids=new ArrayList<>();
        details=new ArrayList<>();
        lends=new ArrayList<>();
        governments=new ArrayList<>();
        gatherings=new ArrayList<>();
        budgets=new ArrayList<>();
        uses=new ArrayList<>();
        currency=new ArrayList<>();
        governments.add("是");
        governments.add("否");
        currency.add("人民币");
        currency.add("欧元");
        currency.add("英镑");
        currency.add("日元");
        budgets.add("住宿费用");
        budgets.add("机票费用");
        budgets.add("吃饭费用");
        budgets.add("打车费用");
        budgets.add("其他费用");
        gatherings.add("怡和网通有限公司");
        gatherings.add("东瑞科技有限公司");
        gatherings.add("万峰快递有限公司");
        gatherings.add("灶埗灶具有限公司");
        gatherings.add("庞盼食品有限公司");
        details.add("办公用品");
        details.add("材料");
        details.add("书籍");
        details.add("体育用品");
        lends.add("2017-1-3,借款15000");
        lends.add("2017-1-9,借款2000");
        lends.add("2017-2-23,借款5000");
        lends.add("2017-3-2,借款3000");
        lends.add("2017-3-26,借款1000");
        uses.add("购销合同");
        uses.add("加工承揽合同");
        uses.add("建设工程承包合同");
        uses.add("货物运输合同");
        uses.add("财产租赁合同");
        uses.add("仓储保管合同");
    }
}
