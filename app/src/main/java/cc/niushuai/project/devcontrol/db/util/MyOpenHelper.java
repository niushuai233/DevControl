package cc.niushuai.project.devcontrol.db.util;

import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.db.greendao.gen.DaoMaster;

/**
 * greendao 自定义
 *
 * @author niushuai233
 * @date 2022/10/24 10:22
 */
public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    /**
     * greendao.schemaVersion 发生变更时触发
     *
     * @param db         数据库
     * @param oldVersion 旧版本
     * @param newVersion 新版本
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.w(Keys.Tag.MY_OPEN_HELPER, "onUpgrade 未实现");
    }
}
