package trypost.dafeng.com.trypost.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by asus on 2017/3/25.
 */
public class ToolsToast {
    /**
     * 土司提示信息
     * @param context
     * @param string 要提示用户的信息
     */
    public static void showToast(Context context,String string){
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }
}
