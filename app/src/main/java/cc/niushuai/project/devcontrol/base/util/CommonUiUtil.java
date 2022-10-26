package cc.niushuai.project.devcontrol.base.util;

import android.app.Activity;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.db.entity.Device;
import cc.niushuai.project.devcontrol.vo.DeviceInfo;

/**
 * 公共ui统一处理工具
 *
 * @author niushuai233
 * @date 2022/10/25 13:57
 */
public class CommonUiUtil {


    /**
     * 得到页面数据值并赋值为对象返回
     *
     * @param activity
     * @param deviceId
     * @author niushuai
     * @date: 2022/10/25 14:01
     * @return: {@link DeviceInfo}
     */
    public static DeviceInfo getDeviceInfo(Activity activity, String deviceId) {

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setId(deviceId);

        deviceInfo.setIconId(UiUtil.getAppImageCompatResourceTag(activity, R.id.device_add_select_icon));

        deviceInfo.setDeviceName(UiUtil.getTextViewTextById(activity, R.id.device_add_name));
        deviceInfo.setCommandPath(UiUtil.getTextViewTextById(activity, R.id.device_add_param_program));
        deviceInfo.setCommandStatus(UiUtil.getTextViewTextById(activity, R.id.device_add_param_status));
        deviceInfo.setCommandOpen(UiUtil.getTextViewTextById(activity, R.id.device_add_param_open));
        deviceInfo.setCommandClose(UiUtil.getTextViewTextById(activity, R.id.device_add_param_close));
        deviceInfo.setRemark(UiUtil.getTextViewTextById(activity, R.id.device_add_param_remark));

        return deviceInfo;
    }

    /**
     * 得到页面数据值并赋值为对象返回
     *
     * @param activity
     * @param deviceId
     * @author niushuai
     * @date: 2022/10/25 14:01
     * @return: {@link Device}
     */
    public static Device getDeviceInfo(Activity activity, Long deviceId) {

        Device device = new Device();
        device.setId(deviceId);

        device.setIconId(UiUtil.getAppImageCompatResourceTag(activity, R.id.device_add_select_icon));

        device.setDeviceName(UiUtil.getTextViewTextById(activity, R.id.device_add_name));
        device.setCommandPath(UiUtil.getTextViewTextById(activity, R.id.device_add_param_program));
        device.setCommandStatus(UiUtil.getTextViewTextById(activity, R.id.device_add_param_status));
        device.setCommandOpen(UiUtil.getTextViewTextById(activity, R.id.device_add_param_open));
        device.setCommandClose(UiUtil.getTextViewTextById(activity, R.id.device_add_param_close));
        device.setRemark(UiUtil.getTextViewTextById(activity, R.id.device_add_param_remark));

        return device;
    }

    /**
     * 回显设备数据
     *
     * @param activity 页面
     * @param device   设备信息
     * @author niushuai
     * @date: 2022/10/25 14:07
     */
    public static void echoDeviceInfo(Activity activity, DeviceInfo device) {
        UiUtil.setTextViewTextById(activity, R.id.device_add_name, device.getDeviceName());
        UiUtil.setTextViewTextById(activity, R.id.device_add_param_program, device.getCommandPath());
        UiUtil.setTextViewTextById(activity, R.id.device_add_param_status, device.getCommandStatus());
        UiUtil.setTextViewTextById(activity, R.id.device_add_param_open, device.getCommandOpen());
        UiUtil.setTextViewTextById(activity, R.id.device_add_param_close, device.getCommandClose());
        UiUtil.setTextViewTextById(activity, R.id.device_add_param_remark, device.getRemark());

        UiUtil.setAppImageCompatResource(activity, R.id.device_add_select_icon, device.getIconId());
    }
}
