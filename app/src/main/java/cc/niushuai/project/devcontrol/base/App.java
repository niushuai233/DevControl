package cc.niushuai.project.devcontrol.base;

import android.content.Context;

import cc.niushuai.project.devcontrol.db.DB;

public class App {

    public static void init(Context context) {

        // 初始化数据库
        initDb(context);
    }

    private static void initDb(Context context) {
        DB.getInstance().init(context);
    }
}
