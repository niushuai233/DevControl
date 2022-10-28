package cc.niushuai.project.devcontrol.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

import java.io.Serializable;

/**
 * 设备日志
 *
 * @author niushuai233
 * @date 2022/10/26 11:56
 */
//@Entity(nameInDb = "tb_dc_device_log")
public class DeviceLog implements Serializable {

    private static final long serialVersionUID = 1175396508635274219L;

    @Id
    private Long id;

    /**
     * 设备id
     */
    @Index
    private Long deviceId;

    /**
     * key
     */
    private String typeKey;

    /**
     * key
     */
    private String typeName;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createTime;
}
