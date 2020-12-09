package com.zzh.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * @author zzh
 * @description:
 * @date :2020/12/9 11:07
 */
public class ToastUtil {
    private static Toast toast;
    public static void show(Context context,CharSequence message){
        if(toast == null){
            toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        }else {
            toast.show();
        }
        toast.show();
    }
}
