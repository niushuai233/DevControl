package cc.niushuai.project.devcontrol.base.enums;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
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
    Switch("Switch", "开关", R.drawable.ic_device_type_switch, PowerSwitchActivity.class),
    Custom("Custom", "自定义设备", R.drawable.ic_device_type_custom, PowerSwitchActivity.class),
    ;

    private String value;
    private String text;
    private int resId;
    private Class<? extends BaseActivity> activity;

    DeviceTypeEnum(String value, String text, int resId, Class<? extends BaseActivity> activity) {
        this.value = value;
        this.text = text;
        this.resId = resId;
        this.activity = activity;
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

    public Class<? extends BaseActivity> getActivity() {
        return activity;
    }

    public void setActivity(Class<? extends BaseActivity> activity) {
        this.activity = activity;
    }
}
