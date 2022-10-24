package cc.niushuai.project.devcontrol.base;

import android.content.Context;

import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.db.DB;

public class App {

    public static void init(Context context) {

        // 初始化数据库
        initDb(context);
        // 重建设备信息缓存
        GlobalVariables.initDeviceInfoMap();
    }

    private static void initDb(Context context) {
        DB.getInstance().init(context);
    }
}
