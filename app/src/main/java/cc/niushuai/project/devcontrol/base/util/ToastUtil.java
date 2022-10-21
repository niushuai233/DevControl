package cc.niushuai.project.devcontrol.base.util;

import android.app.Activity;
import android.widget.Toast;

public class ToastUtil {

    public static void show(Activity activity, String msg) {
        Toast toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }
}
