package cc.niushuai.project.devcontrol.db.util;

import java.util.List;

import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.entity.SysConfig;

/**
 * 抽取的公共方法
 *
 * @author niushuai233
 * @date 2022/10/27 17:23
 */
public class DBHelper {

    private static final String WHERE_KEY = "where key = ?";

    public static List<SysConfig> configListByKey(String key) {

        return DB.getSysConfigDao().queryRaw(WHERE_KEY, key);
    }
}
