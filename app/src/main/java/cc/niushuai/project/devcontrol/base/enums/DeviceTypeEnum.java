package cc.niushuai.project.devcontrol.base.enums;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.ui.custom.DeviceCustomActivity;
import cc.niushuai.project.devcontrol.ui.deviceadd.DeviceAddCustomActivity;
import cc.niushuai.project.devcontrol.ui.deviceadd.DeviceAddPowerSwitchActivity;
import cc.niushuai.project.devcontrol.ui.powerswitch.PowerSwitchActivity;

/**
 * 设备类型枚举
 *
 * @author niushuai
 * @date: 2022/10/17 16:48
 */
public enum DeviceTypeEnum {

    /**
     * 开关
     */
    Power_Switch("Power_Switch", "开关", R.drawable.ic_device_type_switch, DeviceAddPowerSwitchActivity.class, PowerSwitchActivity.class),
    Custom("Custom", "自定义设备", R.drawable.ic_device_type_custom, DeviceAddCustomActivity.class, DeviceCustomActivity.class),
    ;

    private String value;
    private String text;
    private int resId;
    private Class<? extends BaseActivity> deviceAddActivity;
    private Class<? extends BaseActivity> deviceOperateActivity;

    DeviceTypeEnum(String value, String text, int resId,
                   Class<? extends BaseActivity> deviceAddActivity,
                   Class<? extends BaseActivity> deviceOperateActivity) {
        this.value = value;
        this.text = text;
        this.resId = resId;
        this.deviceAddActivity = deviceAddActivity;
        this.deviceOperateActivity = deviceOperateActivity;
    }

    public static DeviceTypeEnum matchByValue(String value) {

        for (DeviceTypeEnum deviceTypeEnum : DeviceTypeEnum.values()) {
            if (deviceTypeEnum.getValue().equals(value)) {
                return deviceTypeEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Class<? extends BaseActivity> getDeviceAddActivity() {
        return deviceAddActivity;
    }

    public void setDeviceAddActivity(Class<? extends BaseActivity> deviceAddActivity) {
        this.deviceAddActivity = deviceAddActivity;
    }

    public Class<? extends BaseActivity> getDeviceOperateActivity() {
        return deviceOperateActivity;
    }

    public void setDeviceOperateActivity(Class<? extends BaseActivity> deviceOperateActivity) {
        this.deviceOperateActivity = deviceOperateActivity;
    }
}
