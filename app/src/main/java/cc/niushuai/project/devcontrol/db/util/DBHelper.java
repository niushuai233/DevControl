package cc.niushuai.project.devcontrol.db.util;

import java.util.Date;
import java.util.List;

import cc.niushuai.project.devcontrol.base.util.IdWorker;
import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.entity.SysConfig;
import cc.niushuai.project.devcontrol.vo.DeviceInfo;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;

/**
 * 抽取的公共方法
 *
 * @author niushuai233
 * @date 2022/10/27 17:23
 */
public class DBHelper {

    private static final String CONFIG_WHERE_KEY = "where key = ?";

    public static void configDeal(String key, String value) {
        List<SysConfig> list = configListByKey(key);
        if (CollUtil.isNotEmpty(list)) {
            configUpdate(value, list.get(0));
            return;
        }
        configInsert(key, value);
    }

    public static void configInsert(String key, String value) {
        DB.getSysConfigDao().insert(new SysConfig(IdWorker.getNextId(), key, value, DateUtil.now(), DateUtil.now()));
    }

    public static void configUpdate(String value, SysConfig updateEntity) {
        updateEntity.setValue(value);
        updateEntity.setUpdateTime(DateUtil.now());

        DB.getSysConfigDao().update(updateEntity);
    }

    public static List<SysConfig> configListByKey(String key) {

        return DB.getSysConfigDao().queryRaw(CONFIG_WHERE_KEY, key);
    }

    public static SysConfig configOneByKey(String key) {

        List<SysConfig> list = DB.getSysConfigDao().queryRaw(CONFIG_WHERE_KEY, key);
        return CollUtil.isEmpty(list) ? null : list.get(0);
    }

    public static void deviceUpdate(DeviceInfo device) {
        device.setUpdateTime(new Date());

        DB.getDeviceDao().update(device.toDevice());
    }
}
