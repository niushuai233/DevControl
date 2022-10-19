package cc.niushuai.project.devcontrol.base.util;

import java.util.HashMap;
import java.util.Map;

import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;

public class GlobalVariables {

    /**
     * 全部设备列表map
     * id为key elem为value
     */
    public static final Map<String, DeviceInfo> DEVICE_INFO_MAP = new HashMap<>(16);

    public static Class<? extends BaseActivity> getDeviceOperateActivity(String deviceId) {
        return DEVICE_INFO_MAP.get(deviceId).getDeviceType().getActivity();
    }

}
