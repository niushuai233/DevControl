package cc.niushuai.project.devcontrol.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;

/**
 * 命令扩展
 *
 * @author niushuai233
 * @date 2022/10/24 14:40
 */
@Entity(nameInDb = "tb_dc_command_ext")
public class CommandExt {

    @Id
    @Index
    private Long id;

    /**
     * 关联设备id
     */
    @Index
    private Long deviceId;

    /**
     * key 备用字段
     */
    @Index
    private String key;

    /**
     * 命令
     */
    private String command;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 命令扩展描述
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createTime;

    @Generated(hash = 704236641)
    public CommandExt(Long id, Long deviceId, String key, String command,
            Integer order, String remark, String createTime) {
        this.id = id;
        this.deviceId = deviceId;
        this.key = key;
        this.command = command;
        this.order = order;
        this.remark = remark;
        this.createTime = createTime;
    }

    @Generated(hash = 962411676)
    public CommandExt() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
