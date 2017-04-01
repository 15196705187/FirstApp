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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.adapter.HomeAdapter;
import trypost.dafeng.com.trypost.adapter.HomePopupWindowAdapter;
import trypost.dafeng.com.trypost.base.MyActivity;
import trypost.dafeng.com.trypost.entity.Picture;
import trypost.dafeng.com.trypost.tools.ToolsToast;

/**
 * Created by asus on 2017/3/25.
 */
public class HomeActivity extends MyActivity {
    View view;
    ImageView iv_back,iv_set,iv_left,iv_center,iv_right,iv_bottom_left,iv_bottom_right;
    GridView gv;
    TextView tv_left,tv_center,tv_right,tv_bottom_left,tv_bottom_right;
    RelativeLayout rl_left,rl_center,rl_right,rl_bottom_left,rl_bottom_right;
    LinearLayout ll;
    HomeAdapter homeAdapter;
    ArrayList<Picture> pictures;
    PopupWindow popupWindow;
    ArrayList<String> strings;
    HomePopupWindowAdapter homePopupWindowAdapter;
    Context context;
    ListView lv;
    @Override
    public void initial() {
        setContentView(R.layout.activity_home);
        view=findViewById(R.id.home_head);
        iv_back= (ImageView) view.findViewById(R.id.title_iv);
        iv_set= (ImageView) view.findViewById(R.id.title_iv_right);
        iv_left= (ImageView) findViewById(R.id.home_iv_left);
        iv_center= (ImageView) findViewById(R.id.home_iv_center);
        iv_right= (ImageView) findViewById(R.id.home_iv_right);
        iv_bottom_left= (ImageView) findViewById(R.id.home_iv_bottom_left);
        iv_bottom_right= (ImageView) findViewById(R.id.home_iv_bottom_right);
        gv= (GridView) findViewById(R.id.home_gv);
        tv_bottom_left= (TextView) findViewById(R.id.home_tv_bottom_left);
        tv_bottom_right= (TextView) findViewById(R.id.home_tv_bottom_right);
        tv_left= (TextView) findViewById(R.id.home_tv_left);
        tv_center= (TextView) findViewById(R.id.home_tv_center);
        tv_right= (TextView) findViewById(R.id.home_tv_right);
        rl_bottom_left= (RelativeLayout) findViewById(R.id.home_rl_bottom_left);
        rl_bottom_right= (RelativeLayout) findViewById(R.id.home_rl_bottom_right);
        rl_center= (RelativeLayout) findViewById(R.id.home_rl_center);
        rl_left= (RelativeLayout) findViewById(R.id.home_rl_left);
        rl_right= (RelativeLayout) findViewById(R.id.home_rl_right);
        ll= (LinearLayout) findViewById(R.id.home_ll_all);
        View view= LayoutInflater.from(this).inflate(R.layout.home_popupwindow,null);
        popupWindow=new PopupWindow(view, 160, RelativeLayout.LayoutParams.WRAP_CONTENT,true);
        lv= (ListView) view.findViewById(R.id.popupwindow_lv);
        homeAdapter=new HomeAdapter(this);
        homePopupWindowAdapter=new HomePopupWindowAdapter(this);
        strings=new ArrayList<>();
        context=this;
    }

    @Override
    public void operator() {
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        homePopupWindowAdapter.setStrings(strings);
        lv.setAdapter(homePopupWindowAdapter);
        homePopupWindowAdapter.notifyDataSetChanged();
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        iv_set.setImageResource(R.mipmap.set01);
        iv_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
        homeAdapter.setList(pictures);
        gv.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
        rl_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,MineActivity.class);
                intent.putExtra("mine","我发起的");
                startActivity(intent);
            }
        });
    }

    @Override
    public void addData() {
        pictures=new ArrayList<>();
        pictures.add(new Picture(R.mipmap.home04,"借款报销",4));
        pictures.add(new Picture(R.mipmap.home05,"费用报销",9));
        pictures.add(new Picture(R.mipmap.home06,"预算执行",2));
        pictures.add(new Picture(R.mipmap.home07,"差旅报销",2));
        pictures.add(new Picture(R.mipmap.home08,"现场收费",6));
        pictures.add(new Picture(R.mipmap.home10,"还款单项",1));
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
    }

    public void show(){
        popupWindow.showAsDropDown(iv_set,-10,30);
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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToolsToast.showToast(context,"点击了第"+i+"个");
            }
        });
    }
}
