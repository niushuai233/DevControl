package cc.niushuai.project.devcontrol.base.enums;

import cc.niushuai.project.devcontrol.R;

/**
 * icon枚举
 *
 * @author niushuai233
 * @date 2022/10/25 14:57
 */
public enum IconEnum {
    POWER_SWITCH(R.drawable.ic_device_type_switch, "开关"),
    LIGHT(R.drawable.ic_device_type_light, "灯具"),
    CAMERA(R.drawable.ic_device_type_camera, "摄像机"),
    AIR_CONDITIONER(R.drawable.ic_device_type_air_conditioner, "空调"),
    REFRIGERATOR(R.drawable.ic_device_type_refrigerator, "冰箱"),
    SOCKET(R.drawable.ic_device_type_socket, "插座"),
    WASHER(R.drawable.ic_device_type_washer, "洗衣机"),
    DEVICE(R.drawable.ic_device_type_custom, "设备"),
    ;

    /**
     * 资源id
     */
    private Integer iconId;
    /**
     * 描述
     */
    private String desc;

    IconEnum(Integer iconId, String desc) {
        this.iconId = iconId;
        this.desc = desc;
    }

    public Integer getIconId() {
        return iconId;
    }

    public String getDesc() {
        return desc;
    }
}
