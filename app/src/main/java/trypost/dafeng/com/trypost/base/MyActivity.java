package trypost.dafeng.com.trypost.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by asus on 2017/3/25.
 */
public abstract class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initial();
        addData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        operator();
    }

    /**
     * 初始化控件或者是对象的方法
     */
    public abstract void initial();

    /**
     * 相关操作、功能实现、逻辑编写的地方
     */
    public abstract void operator();

    /**
     * 一般是用于简单集合数据加载的地方
     */
    public abstract void addData();
}
