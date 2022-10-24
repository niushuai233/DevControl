package cc.niushuai.project.devcontrol.base.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.entity.Device;
import cc.niushuai.project.devcontrol.vo.DeviceInfo;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;

public class GlobalVariables {

    /**
     * 全部设备列表map
     * id为key elem为value
     */
    public static final Map<String, DeviceInfo> DEVICE_INFO_MAP = new HashMap<>(16);

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
            DEVICE_INFO_MAP.put(device.getId() + "", DeviceInfo.convert(device));
        }
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
