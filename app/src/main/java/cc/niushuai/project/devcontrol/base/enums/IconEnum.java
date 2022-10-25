package cc.niushuai.project.devcontrol.base.enums;

import cc.niushuai.project.devcontrol.R;

/**
 * icon枚举
 *
 * @author niushuai233
 * @date 2022/10/25 14:57
 */
public enum IconEnum {

    POWER_SWITCH(R.drawable.ic_device_type_switch, R.drawable.ic_device_type_switch, "开关"),
    LIGHT(R.drawable.ic_device_type_light, R.drawable.ic_device_type_light, "灯具"),
    CAMERA(R.drawable.ic_device_type_camera, R.drawable.ic_device_type_camera, "摄像机"),
    AIR_CONDITIONER(R.drawable.ic_device_type_air_conditioner, R.drawable.ic_device_type_air_conditioner, "空调"),
    REFRIGERATOR(R.drawable.ic_device_type_refrigerator, R.drawable.ic_device_type_refrigerator, "冰箱"),
    SOCKET(R.drawable.ic_device_type_socket, R.drawable.ic_device_type_socket, "插座"),
    WASHER(R.drawable.ic_device_type_washer, R.drawable.ic_device_type_washer, "洗衣机"),
    DEVICE(R.drawable.ic_device_type_custom, R.drawable.ic_device_type_custom, "设备"),
    ;

    /**
     * 暗色资源id
     */
    private Integer iconIdDark;

    /**
     * 亮色资源id
     */
    private Integer iconIdLight;

    /**
     * 描述
     */
    private String desc;

    IconEnum(Integer iconIdDark, Integer iconIdLight, String desc) {
        this.iconIdDark = iconIdDark;
        this.iconIdLight = iconIdLight;
        this.desc = desc;
    }

    public Integer getIconIdDark() {
        return iconIdDark;
    }

    public Integer getIconIdLight() {
        return iconIdLight;
    }

    public String getDesc() {
        return desc;
    }
}
