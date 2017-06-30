package top.teemo.myutils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * Created by Administrator on 2017/6/9.
 */

public class ToastUtil {
    public static void reset(){
        Toasty.Config.reset();
    }
    public static void error(Context ctx, String str){
        Toasty.error(ctx, str, Toast.LENGTH_SHORT, true).show();
    }
    public static void info(Context ctx, String str){
        Toasty.info(ctx, str, Toast.LENGTH_SHORT, true).show();
    }
    public static void warning(Context ctx, String str){
        Toasty.warning(ctx, str, Toast.LENGTH_SHORT, true).show();
    }
    public static void normal(Context ctx, String str){
        Toasty.normal(ctx, str, Toast.LENGTH_SHORT).show();
    }
    public static void normalWithIcon(Context ctx, String str, Drawable icon){
        Toasty.normal(ctx, str, Toast.LENGTH_SHORT, icon).show();
    }
}
