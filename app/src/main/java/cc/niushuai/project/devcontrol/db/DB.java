package cc.niushuai.project.devcontrol.db;

import android.content.Context;

import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.db.greendao.gen.DaoMaster;
import cc.niushuai.project.devcontrol.db.greendao.gen.DaoSession;
import cc.niushuai.project.devcontrol.db.greendao.gen.DeviceDao;
import cc.niushuai.project.devcontrol.db.util.MyOpenHelper;

/**
 * 数据库初始化
 *
 * @author niushuai233
 * @date 2022/10/24 10:44
 */
public class DB {

    private static boolean INIT_FLAG = false;

    private static DB db;
    private Context context;
    private DaoMaster.OpenHelper openHelper;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DB() {
    }

    public static DB getInstance() {
        if (null == db) {
            db = new DB();
        }
        return db;
    }

    /**
     * daoSession 对外暴漏入口
     *
     * @author niushuai
     * @date: 2022/10/24 11:04
     * @return: {@link DaoSession}
     */
    public static DaoSession session() {
        return DB.getInstance().getDaoSession();
    }

    /**
     * 设备操作入口
     *
     * @author niushuai
     * @date: 2022/10/24 11:05
     * @return: {@link DeviceDao}
     */
    public static DeviceDao getDeviceDao() {
        return session().getDeviceDao();
    }

    /**
     * 初始化数据库表结构
     *
     * @param context
     * @author niushuai
     * @date: 2022/10/24 10:46
     */
    public void init(Context context) {
        if (!INIT_FLAG) {
            DB instance = DB.getInstance();
            instance.context = context;
//            instance.getOpenHelper();
//            instance.getDaoMaster();
            instance.getDaoSession();
            INIT_FLAG = true;
        }
    }

    /**
     * 初始化open helper
     *
     * @author niushuai
     * @date: 2022/10/24 10:53
     * @return: {@link DaoMaster.OpenHelper}
     */
    public DaoMaster.OpenHelper getOpenHelper() {
        if (null == openHelper) {
            openHelper = new MyOpenHelper(context, Keys.DB_FILE_NAME);
        }
        return openHelper;
    }

    public DaoMaster getDaoMaster() {
        if (null == daoMaster) {
            daoMaster = new DaoMaster(getOpenHelper().getWritableDb());
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        if (null == daoSession) {
            daoSession = getDaoMaster().newSession();
        }
        return daoSession;
    }
}
