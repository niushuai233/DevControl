package cc.niushuai.project.devcontrol.base;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cc.niushuai.project.devcontrol.BuildConfig;
import cc.niushuai.project.devcontrol.base.util.Global;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.XLog;
import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.entity.SysConfig;
import cc.niushuai.project.devcontrol.db.util.DBHelper;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;

public class App {

    public static final String WHICH_SU = "which su";

    public static void init(Activity activity) {

        // 申请权限
        requestPermissions(activity);
        // 初始化数据库
        initDb(activity);
        // 初始化日志相关内容
        initLogSupport(activity);
        // 检查root权限
        checkRoot(activity);
        // 重建设备信息缓存
//        Global.initDeviceInfoMap();

        XLog.i(Keys.Tag.APP_INIT, "应用{}初始化完毕", BuildConfig.APP_NAME);
    }

    /**
     * 检查root权限
     *
     * @param activity
     * @author niushuai
     * @date: 2022/10/26 15:02
     */
    private static void checkRoot(Activity activity) {

        String which_su = RuntimeUtil.execForStr(WHICH_SU);
        XLog.v(Keys.Tag.APP_INIT, "检查root权限... {} ==> {}", WHICH_SU, which_su);
        if (StrUtil.isNotEmpty(which_su)) {
            Global.HAS_ROOT = true;
            XLog.v(Keys.Tag.APP_INIT, "当前设备具有root权限");
        } else {
            XLog.v(Keys.Tag.APP_INIT, "当前设备不具有root权限");
        }
    }

    /**
     * 请求权限
     *
     * @param activity
     * @author niushuai
     * @date: 2022/10/26 14:58
     */
    private static void requestPermissions(Activity activity) {
        // 所需权限列表
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE,
        };

        // 待重新申请权限列表
        List<String> permissionsList = new ArrayList<>();
        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != activity.checkSelfPermission(perm)) {
                // 进入到这里代表没有权限
                permissionsList.add(perm);
            }
        }

        // 重新申请权限
        if (!permissionsList.isEmpty()) {
            String[] strings = new String[permissionsList.size()];
            activity.requestPermissions(permissionsList.toArray(strings), 0);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                activity.startActivity(intent);
                return;
            }
        }

    }

    /**
     * 初始化数据库文件
     *
     * @param activity
     * @author niushuai
     * @date: 2022/10/26 14:58
     */
    private static void initDb(Activity activity) {
        XLog.d(Keys.Tag.APP_INIT, "加载SQLite");
        DB.getInstance().init(activity);
    }

    /**
     * 初始化日志内容
     *
     * @author niushuai
     * @date: 2022/10/26 15:00
     */
    private static void initLogSupport(Activity activity) {

        SysConfig switchConfig = DBHelper.configOneByKey(Keys.SETUP_LOG_SWITCH);
        if (null != switchConfig) {
            XLog.SWITCH = Boolean.valueOf(switchConfig.getValue());
            XLog.SWITCH_FOR_FILE = Boolean.valueOf(switchConfig.getValue());
        }

        SysConfig levelConfig = DBHelper.configOneByKey(Keys.SETUP_LOG_LEVEL);
        if (null != levelConfig) {
            XLog.ROOT_LEVEL = XLog.Level.transform(levelConfig.getValue());
            XLog.ROOT_LEVEL_NAME = XLog.Level.transform(XLog.ROOT_LEVEL);
        }

        SysConfig keepDayConfig = DBHelper.configOneByKey(Keys.SETUP_LOG_KEEP_DAY);
        if (null != keepDayConfig) {
            XLog.KEEP_DAY = Integer.valueOf(keepDayConfig.getValue());
        }

        // 初始化日志路径
        String rootPath = getRootPath();

        if (!FileUtil.exist(rootPath)) {
            // 不存在的时候创建文件
            boolean mkdirs = new File(rootPath).mkdirs();
            XLog.v(Keys.Tag.APP_INIT, "日志根目录不存在, 创建: {}", mkdirs);
        }

        // 内存存储日志根目录
        Global.LOG_ROOT_PATH = rootPath;
        XLog.d(Keys.Tag.APP_INIT, "日志开关: {}", XLog.SWITCH);
        XLog.d(Keys.Tag.APP_INIT, "日志存储位置: {}", Global.LOG_ROOT_PATH);
        XLog.d(Keys.Tag.APP_INIT, "日志级别: {}", XLog.ROOT_LEVEL_NAME);
        XLog.d(Keys.Tag.APP_INIT, "日志保留天数: {}", XLog.KEEP_DAY);
    }

    private static String getRootPath() {
        String rootPath = "";

        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
            // 如果存在外置存储
            rootPath = StrUtil.join(StrPool.SLASH, Environment.getExternalStorageDirectory().getAbsolutePath(), BuildConfig.APP_NAME);
        } else {
            // 否则就写到/data/data里
            rootPath = StrUtil.join(StrPool.SLASH, Keys.LOG_ROOT_FILE_PATH, BuildConfig.APPLICATION_ID);
        }

        return StrUtil.join(StrPool.SLASH, rootPath, Keys.LOG_LOG_FOLDER);
    }

}
