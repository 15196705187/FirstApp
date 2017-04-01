package trypost.dafeng.com.trypost.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.adapter.ReimburseAdapter;
import trypost.dafeng.com.trypost.base.MyActivity;
import trypost.dafeng.com.trypost.entity.Mine;

/**
 * Created by asus on 2017/3/27.
 */
public class ApplyReimburseActivity extends MyActivity {
    View view;
    TextView tv_head;
    RecyclerView lv;
    ImageView iv_head,iv_head_right;
    ReimburseAdapter reimburseAdapter;
    ArrayList<Integer> integers;
    LinearLayoutManager manager;
    Mine mines;
    String string;
    @Override
    public void initial() {
       setContentView(R.layout.activity_apply_reimburse);
        view=findViewById(R.id.apply_reimburse_head);
        tv_head= (TextView) view.findViewById(R.id.title_tv_center);
        iv_head= (ImageView) view.findViewById(R.id.title_iv);
        iv_head_right= (ImageView) view.findViewById(R.id.title_iv_right);
        lv= (RecyclerView) findViewById(R.id.apply_reimburse_lv);
        reimburseAdapter=new ReimburseAdapter(this);
        manager=new LinearLayoutManager(this);
        lv.setLayoutManager(manager);
        Intent intent=getIntent();
        if (intent!=null){
            string=intent.getStringExtra("mine");
            mines= (Mine) intent.getSerializableExtra("item");
        }
    }

    @Override
    public void operator() {
        iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addList();
        tv_head.setText(string);
        iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void addData() {
        integers=new ArrayList<>();
        integers.add(1);
    }

    public void addList(){
        reimburseAdapter.setList(integers);
        reimburseAdapter.setMine(mines);
        lv.setAdapter(reimburseAdapter);
        reimburseAdapter.notifyDataSetChanged();
    }

}
