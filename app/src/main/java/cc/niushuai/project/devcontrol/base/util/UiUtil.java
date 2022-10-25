package cc.niushuai.project.devcontrol.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

public class UiUtil {

    public static int dip2px(Context context, float dipValue) {
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }

    public static String getTextViewTextById(Activity activity, int id) {
        return ((TextView) activity.findViewById(id)).getText().toString();
    }

//    public static String getTextViewTextById(View view, int id) {
//        return ((TextView) view.findViewById(id)).getText().toString();
//    }

    public static void setTextViewTextById(Activity activity, int id, String text) {
        ((TextView) activity.findViewById(id)).setText(text);
    }

//    public static void setTextViewTextById(View view, int id, String text) {
//        ((TextView) view.findViewById(id)).setText(text);
//    }

    public static void setImageResource(Activity activity, int id, int resId) {
        ((ImageView) activity.findViewById(id)).setImageResource(resId);
    }

//    public static void setImageResource(View view, int id, int resId) {
//        ((ImageView) view.findViewById(id)).setImageResource(resId);
//    }

    public static void setAppImageCompatResource(Activity activity, int id, int resId) {
        ((AppCompatImageView) activity.findViewById(id)).setImageResource(resId);
    }

//    public static void setAppImageCompatResource(View view, int id, int resId) {
//        ((AppCompatImageView) view.findViewById(id)).setImageResource(resId);
//    }
}
