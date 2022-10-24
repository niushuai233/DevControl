package cc.niushuai.project.devcontrol.db.entity;

import org.greenrobot.greendao.annotation.Entity;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * 设备数据库实体
 *
 * @author niushuai233
 * @date 2022/10/24 14:11
 */
@Entity(nameInDb = "tb_dc_device")
public class Device implements Serializable {

    private static final long serialVersionUID = -3161350126173955730L;

    @Id
    private Long id;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 开关状态
     */
    private String onOff;
    
    /**
     * 设备列表界面 list icon id
     */
    private Integer iconId;

    /**
     * <pre>
     *  二进制文件存放位置
     *  /文件夹/二进制文件 参数
     * </pre>
     */
    private String commandPath;

    /**
     * 查询状态参数
     */
    private String commandStatus;

    /**
     * 开启参数
     */
    private String commandOpen;

    /**
     * 关闭参数
     */
    private String commandClose;

    /**
     * 删除标志
     */
    private Integer isDeleted;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createTime;

    @Generated(hash = 1723639212)
    public Device(Long id, Integer order, String deviceName, String deviceType,
            String onOff, Integer iconId, String commandPath, String commandStatus,
            String commandOpen, String commandClose, Integer isDeleted,
            String remark, String createTime) {
        this.id = id;
        this.order = order;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.onOff = onOff;
        this.iconId = iconId;
        this.commandPath = commandPath;
        this.commandStatus = commandStatus;
        this.commandOpen = commandOpen;
        this.commandClose = commandClose;
        this.isDeleted = isDeleted;
        this.remark = remark;
        this.createTime = createTime;
    }

    @Generated(hash = 1469582394)
    public Device() {
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOnOff() {
        return this.onOff;
    }

    public void setOnOff(String onOff) {
        this.onOff = onOff;
    }

    public Integer getIconId() {
        return this.iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public String getCommandPath() {
        return this.commandPath;
    }

    public void setCommandPath(String commandPath) {
        this.commandPath = commandPath;
    }

    public String getCommandOpen() {
        return this.commandOpen;
    }

    public void setCommandOpen(String commandOpen) {
        this.commandOpen = commandOpen;
    }

    public String getCommandClose() {
        return this.commandClose;
    }

    public void setCommandClose(String commandClose) {
        this.commandClose = commandClose;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCommandStatus() {
        return this.commandStatus;
    }

    public void setCommandStatus(String commandStatus) {
        this.commandStatus = commandStatus;
    }
}
