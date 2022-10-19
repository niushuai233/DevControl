package cc.niushuai.project.devcontrol.base.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import cc.niushuai.project.devcontrol.base.ui.BaseActivity;

public class ActivityUtil {

    public static void startActivity(Activity sourceActivity, Class<? extends BaseActivity> targetActivity) {

        startActivity(sourceActivity, targetActivity, null);
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
