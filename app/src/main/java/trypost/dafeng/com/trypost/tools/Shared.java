package trypost.dafeng.com.trypost.tools;

import android.content.Context;
import android.content.SharedPreferences;

import trypost.dafeng.com.trypost.entity.User;

/**
 * Created by asus on 2017/3/25.
 */
public class Shared {
    /**
     * 存入记住密码的共享参数
     */
    public static void savePwd(Context context,boolean flag){
        SharedPreferences sharedPreferences=context.getSharedPreferences("password",Context.MODE_APPEND);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("pwd",flag);
        editor.commit();
    }

    /**
     * 取出记住密码共享参数
     * @param context
     * @return
     */
    public static boolean getPwd(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("password",Context.MODE_APPEND);
        boolean flag=sharedPreferences.getBoolean("pwd",false);
        return flag;
    }

    /**
     * 存入自动登陆的共享参数
     */
    public static void saveLogin(Context context,boolean flag){
        SharedPreferences sharedPreferences=context.getSharedPreferences("login",Context.MODE_APPEND);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("log",flag);
        editor.commit();
    }

    /**
     * 取出自动登陆共享参数
     * @param context
     * @return
     */
    public static boolean getLogin(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("login",Context.MODE_APPEND);
        boolean flag=sharedPreferences.getBoolean("log",false);
        return flag;
    }

    /**
     * 存入最新登入的用户
     * @param context
     * @param user
     */
    public static  void saveUser(Context context, User user){
        SharedPreferences sharedPreferences=context.getSharedPreferences("user",Context.MODE_APPEND);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("account",user.getAccount());
        editor.putString("password",user.getPassword());
        editor.commit();
    }

    /**
     * 取出存入的用户
     * @param context
     * @return
     */
    public static  User getUser(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("user",Context.MODE_APPEND);
        String account=sharedPreferences.getString("account","");
        String password=sharedPreferences.getString("password","");
        User user=new User(account,password);
        return user;
    }
}
