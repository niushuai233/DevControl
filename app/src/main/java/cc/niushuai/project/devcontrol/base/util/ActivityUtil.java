package cc.niushuai.project.devcontrol.base.util;

import android.app.Activity;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

import cc.niushuai.project.devcontrol.base.ui.BaseActivity;

public class ActivityUtil {

    public static void startActivity(Activity sourceActivity, Class<? extends BaseActivity> targetActivity) {

        startActivity(sourceActivity, targetActivity, null);
    }

    public static void startActivity(Activity sourceActivity, Class<? extends BaseActivity> targetActivity, String[] keys, String[] values) {

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        startActivity(sourceActivity, targetActivity, map);
    }

    public static void startActivity(Activity sourceActivity, Class<? extends BaseActivity> targetActivity,
                                     Map<String, String> withData) {
        Intent intent = new Intent(sourceActivity, targetActivity);
        if (null != withData) {
            for (String key : withData.keySet()) {
                intent.putExtra(key, withData.get(key));
            }
        }
        sourceActivity.startActivity(intent);
    }
}
