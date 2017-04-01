package trypost.dafeng.com.trypost.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import trypost.dafeng.com.trypost.R;
import trypost.dafeng.com.trypost.base.MyActivity;
import trypost.dafeng.com.trypost.entity.User;
import trypost.dafeng.com.trypost.tools.Shared;
import trypost.dafeng.com.trypost.tools.ToolsToast;

/**
 * Created by asus on 2017/3/25.
 */
public class LoginActivity extends MyActivity {
    TextView title_tv;
    ImageView title_iv,login_logo;
    EditText account_et,pwd_et;
    CheckBox remember_cb,login_cb;
    Button login_btn;
    View view;
    ArrayList<User> users;
    Context context;
    User user;
    boolean flag_remember,flag_login;
    @Override
    public void initial() {
      setContentView(R.layout.activity_login);
        context=this;
        view=findViewById(R.id.login_head);
        title_tv= (TextView) view.findViewById(R.id.title_tv_center);
        title_iv= (ImageView) view.findViewById(R.id.title_iv);
        login_logo= (ImageView) findViewById(R.id.login_iv_logo);
        account_et= (EditText) findViewById(R.id.login_et_account);
        pwd_et= (EditText) findViewById(R.id.login_et_pwd);
        login_btn= (Button) findViewById(R.id.login_btn_login);
        remember_cb= (CheckBox) findViewById(R.id.login_cb_left);
        login_cb= (CheckBox) findViewById(R.id.login_cb_right);
    }

    @Override
    public void operator() {
        flag_remember=Shared.getPwd(context);
        flag_login=Shared.getLogin(context);
        user=Shared.getUser(context);
        if (flag_login){
            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
            intent.putExtra("account",user.getAccount());
            startActivity(intent);
            finish();
            return;
        }
        if (flag_remember){
            remember_cb.setChecked(flag_remember);
            account_et.setText(user.getAccount());
            pwd_et.setText(user.getPassword());
        }else {
            account_et.setText(user.getAccount());
        }
      login_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String account=account_et.getText().toString();
              String pwd=pwd_et.getText().toString();
              flag_login=login_cb.isChecked();
              flag_remember=remember_cb.isChecked();
              if (account==null||pwd==null){
                  ToolsToast.showToast(context,"用户名和密码不能为空");
                  return;
              }
              if (account.length()==0||pwd.length()==0){
                  ToolsToast.showToast(context,"用户名和密码不能为空");
                  return;
              }
              for (int i = 0; i <users.size() ; i++) {
                  if (account.equals(users.get(i).getAccount())&&pwd.equals(users.get(i).getPassword())){
                      user=users.get(i);
                      Shared.saveLogin(context,flag_login);
                      Shared.savePwd(context,flag_remember);
                      Shared.saveUser(context,user);
                      Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                      intent.putExtra("account",user.getAccount());
                      startActivity(intent);
                      finish();
                      return;
                  }
                  if (i==users.size()-1){
                      ToolsToast.showToast(context,"账号或密码错误");
                  }
              }
          }
      });
        title_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void addData() {
      users=new ArrayList<>();
        users.add(new User("张三","123456"));
        users.add(new User("李四","654321"));
        users.add(new User("小明","666666"));
        users.add(new User("小红","222222"));
    }
}
