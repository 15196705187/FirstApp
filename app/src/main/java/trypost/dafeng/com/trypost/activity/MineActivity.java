package trypost.dafeng.com.trypost.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.adapter.MineAdapter;
import trypost.dafeng.com.trypost.base.MyActivity;
import trypost.dafeng.com.trypost.entity.Mine;

/**
 * Created by asus on 2017/3/25.
 */
public class MineActivity extends MyActivity {
    View view;
    ListView lv;
    ArrayList<Mine> list,listpass,listback,listreim;
    MineAdapter mineAdapter;
    TextView tv_head,tv_waite,tv_pass,tv_back,tv_add,tv_update,tv_delete,tv_commit,tv_up,tv_reiming;
    ImageView iv_back,iv_head_right;
    LinearLayout title_ll;
    Context context;
    @Override
    public void initial() {
        setContentView(R.layout.activity_mine);
        view=findViewById(R.id.mine_head);
        lv= (ListView) findViewById(R.id.mine_lv);
        tv_head= (TextView) view.findViewById(R.id.title_tv_center);
        iv_back= (ImageView) view.findViewById(R.id.title_iv);
        iv_head_right= (ImageView) view.findViewById(R.id.title_iv_right);
        title_ll= (LinearLayout) view.findViewById(R.id.title_ll);
        tv_add= (TextView) findViewById(R.id.mine_tv_add);
        tv_back= (TextView) findViewById(R.id.mine_tv_back);
        tv_pass= (TextView) findViewById(R.id.mine_tv_pass);
        tv_update= (TextView) findViewById(R.id.mine_tv_update);
        tv_commit= (TextView) findViewById(R.id.mine_tv_commit);
        tv_up= (TextView) findViewById(R.id.mine_tv_up);
        tv_waite= (TextView) findViewById(R.id.mine_tv_waite);
        tv_delete= (TextView) findViewById(R.id.mine_tv_delete);
        tv_reiming= (TextView) findViewById(R.id.mine_tv_reiming);
        mineAdapter=new MineAdapter(this);
        context=this;
    }

    @Override
    public void operator() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MineActivity.this,ApplyReimburseActivity.class);
                intent.putExtra("mine","申请报销");
                startActivity(intent);
            }
        });
        tv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MineActivity.this,ApplyReimburseActivity.class);
                intent.putExtra("mine","修改报销");
                intent.putExtra("item",new Mine("东哥","2017-3-27","重庆出差","王经理",8000,"财务初审","差旅费"));
                startActivity(intent);
            }
        });
       title_ll.setVisibility(View.VISIBLE);
        Intent intent=getIntent();
        String string="";
        if (intent!=null){
            string=intent.getStringExtra("mine");
        }
        tv_head.setText(string);
        tv_waite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_waite.setTextColor(Color.parseColor("#0c800c"));
                tv_back.setTextColor(Color.BLACK);
                tv_pass.setTextColor(Color.BLACK);
                tv_reiming.setTextColor(Color.BLACK);
                mineAdapter.setList(list);
                lv.setAdapter(mineAdapter);
                mineAdapter.notifyDataSetChanged();
            }
        });
        tv_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_pass.setTextColor(Color.parseColor("#0c800c"));
                tv_back.setTextColor(Color.BLACK);
                tv_waite.setTextColor(Color.BLACK);
                tv_reiming.setTextColor(Color.BLACK);
                mineAdapter.setList(listpass);
                lv.setAdapter(mineAdapter);
                mineAdapter.notifyDataSetChanged();
            }
        });
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_back.setTextColor(Color.parseColor("#0c800c"));
                tv_waite.setTextColor(Color.BLACK);
                tv_pass.setTextColor(Color.BLACK);
                tv_reiming.setTextColor(Color.BLACK);
                mineAdapter.setList(listback);
                lv.setAdapter(mineAdapter);
                mineAdapter.notifyDataSetChanged();
            }
        });
        tv_reiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_reiming.setTextColor(Color.parseColor("#0c800c"));
                tv_waite.setTextColor(Color.BLACK);
                tv_pass.setTextColor(Color.BLACK);
                tv_back.setTextColor(Color.BLACK);
                mineAdapter.setList(listreim);
                lv.setAdapter(mineAdapter);
                mineAdapter.notifyDataSetChanged();
            }
        });
        tv_waite.setTextColor(Color.parseColor("#0c800c"));
        mineAdapter.setList(list);
        lv.setAdapter(mineAdapter);
        mineAdapter.notifyDataSetChanged();
    }

    @Override
    public void addData() {
        listreim=new ArrayList<>();
        list=new ArrayList<>();
        listpass=new ArrayList<>();
        listback=new ArrayList<>();
        list.add(new Mine("张三-研发一部","下一节点，财务初审","昆明出差","审批人李经理",1453,"2017-3-22","差旅费报销"));//构造函数以此处为标准，以为财务和时间在布局中已经调换了
        list.add(new Mine("李四-研发二部","下一节点，财务初审","北京商谈","审批人王经理",4533.6,"2017-3-22","费用报销"));
        list.add(new Mine("赵五-研发五部","下一节点，财务初审","大明湖派遣","审批人张经理",2253.9,"2017-3-22","差旅费报销"));
        list.add(new Mine("小红-研发三部","下一节点，财务初审","计算机设备购入","审批人沈经理",4153.3,"2017-3-22","费用报销"));
        list.add(new Mine("小明-研发二部","下一节点，财务初审","车费报销","审批人王经理",153.3,"2017-3-22","费用报销"));
        list.add(new Mine("小亮-研发四部","下一节点，财务初审","昆明出差","审批人李经理",556.1,"2017-3-22","差旅费报销"));
        list.add(new Mine("小新-研发三部","下一节点，财务初审","昆明出差","审批人沈经理",533.2,"2017-3-22","差旅费报销"));
        listpass.add(new Mine("王平-材料部门","财务已通过审批","购入食材","肖经理已审批",666453.213,"2017-3-22","现场收费"));
        listpass.add(new Mine("李峰-管理部门","财务已通过审批","外派","吴经理已通过审批",533653.213,"2017-3-22","差旅费报销"));
        listpass.add(new Mine("任东勋-设计部门","财务已通过审批","出国学习","沈经理已通过审批",523453.213,"2017-3-22","现场收费"));
        listback.add(new Mine("东城-产品测试部门","财务已驳回","设备购入","沈经理已驳回",6666,"2017-3-22","现场收费"));
        listreim.add(new Mine("小红-研发三部","待财务审批","计算机设备购入","待沈经理审批",4153.3,"2017-3-22","现场收费"));
        listreim.add(new Mine("小明-研发二部","待财务审批","车费报销","待王经理审批",153.3,"2017-3-22","费用报销"));
        listreim.add(new Mine("小亮-研发四部","待财务审批","昆明出差","待李经理审批",556.1,"2017-3-22","差旅费报销"));
    }

    public void add(){
        View view= LayoutInflater.from(context).inflate(R.layout.mine_item_add,null);
        PopupWindow popupWindow=new PopupWindow(view, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        popupWindow.showAtLocation(lv, Gravity.CENTER,0,0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }
}
