package cc.niushuai.project.devcontrol.base.enums;

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
    Switch("Switch", PowerSwitchActivity.class),
    ;


    private String value;
    private Class<? extends BaseActivity> activity;

    DeviceTypeEnum(String value, Class<? extends BaseActivity> activity) {
        this.value = value;
        this.activity = activity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Class<? extends BaseActivity> getActivity() {
        return activity;
    }

    public void setActivity(Class<? extends BaseActivity> activity) {
        this.activity = activity;
    }
}
