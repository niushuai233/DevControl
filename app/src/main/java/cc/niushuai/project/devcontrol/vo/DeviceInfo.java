package cc.niushuai.project.devcontrol.vo;

import java.util.ArrayList;
import java.util.List;

import cc.niushuai.project.devcontrol.base.entity.BaseVO;
import cc.niushuai.project.devcontrol.base.enums.DeviceTypeEnum;
import cc.niushuai.project.devcontrol.base.enums.OnOffEnum;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.IdWorker;

/**
 * 设备信息实体数据类
 *
 * @author niushuai
 * @date: 2022/10/17 16:47
 */
public class DeviceInfo extends BaseVO {

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备类型
     */
    private DeviceTypeEnum deviceType;

    /**
     * 开关状态
     */
    private OnOffEnum onOff;

    /**
     * 设备列表界面 list icon id
     */
    private int iconId;

    /**
     * <pre>
     *  二进制文件存放位置
     *  /文件夹/二进制文件 参数
     * </pre>
     */
    private String commandPath;

    /**
     * 开启参数
     */
    private String commandOpen;

    /**
     * 关闭参数
     */
    private String commandClose;

    /**
     * 扩展参数集合
     */
    private List<String> commandExtra;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceTypeEnum getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceTypeEnum deviceType) {
        this.deviceType = deviceType;
    }

    public OnOffEnum getOnOff() {
        return onOff;
    }

    public void setOnOff(OnOffEnum onOff) {
        this.onOff = onOff;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getCommandPath() {
        return commandPath;
    }

    public void setCommandPath(String commandPath) {
        this.commandPath = commandPath;
    }

    public String getCommandOpen() {
        return commandOpen;
    }

    public void setCommandOpen(String commandOpen) {
        this.commandOpen = commandOpen;
    }

    public String getCommandClose() {
        return commandClose;
    }

    public void setCommandClose(String commandClose) {
        this.commandClose = commandClose;
    }

    public List<String> getCommandExtra() {
        return commandExtra;
    }

    public void setCommandExtra(List<String> commandExtra) {
        this.commandExtra = commandExtra;
    }

    /**
     * mock 假数据
     *
     * @author niushuai
     * @date: 2022/10/17 17:02
     * @return: {@link List<DeviceInfo>}
     */
    public static List<DeviceInfo> mock(int size, int iconId) {
        List<DeviceInfo> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            DeviceInfo device = new DeviceInfo();
            device.setId(IdWorker.getNextIdStr());
            device.setDeviceName("卧室灯开关" + (i + 1));
            device.setIconId(iconId);
            device.setRemark("卧室灯开关-树莓派");
            device.setDeviceType(DeviceTypeEnum.Power_Switch);
            device.setOnOff(OnOffEnum.OFF);
            device.setCommandPath("/path/file");
            device.setCommandOpen("-c light -t 1");
            device.setCommandClose("-c light -t 0");
            list.add(device);

            GlobalVariables.DEVICE_INFO_MAP.put(device.getId(), device);
        }

        return list;
    }
}
