package cc.niushuai.project.devcontrol.base.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.niushuai.project.devcontrol.BuildConfig;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.entity.Device;
import cc.niushuai.project.devcontrol.vo.DeviceInfo;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;

public class GlobalVariables {

    /**
     * 全部设备列表map
     * id为key elem为value
     */
    public static final Map<String, DeviceInfo> DEVICE_INFO_MAP = new HashMap<>(16);
    public static String LOG_ROOT_PATH = StrUtil.join(StrPool.SLASH, Keys.LOG_ROOT_FILE_PATH,  BuildConfig.APPLICATION_ID, Keys.LOG_LOG_FOLDER);

    /**
     * 初始化设备列表到缓存中
     *
     * @author niushuai
     * @date: 2022/10/24 17:08
     */
    public static void initDeviceInfoMap() {
        DEVICE_INFO_MAP.clear();
        List<Device> deviceList = DB.getDeviceDao().loadAll();

        for (Device device : deviceList) {
            DEVICE_INFO_MAP.put(device.getId() + "", DeviceInfo.parseDevice(device));
        }
        System.out.println();
    }

    public static Class<? extends BaseActivity> getDeviceAddActivity(String deviceId) {
        return getDeviceInfo(deviceId).getDeviceType().getDeviceAddActivity();
    }

    public static Class<? extends BaseActivity> getDeviceOperateActivity(String deviceId) {
        return getDeviceInfo(deviceId).getDeviceType().getDeviceOperateActivity();
    }

    public static DeviceInfo getDeviceInfo(String deviceId) {
        return DEVICE_INFO_MAP.get(deviceId);
    }
}
