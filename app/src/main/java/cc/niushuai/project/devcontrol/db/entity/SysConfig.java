package cc.niushuai.project.devcontrol.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 设置项
 *
 * @author niushuai233
 * @date 2022/10/27 16:19
 */
@Entity(nameInDb = "tb_dc_config")
public class SysConfig {

    @Id
    private Long id;

    @Index
    private String key;

    private String value;

    private String createTime;

    private String updateTime;

    @Generated(hash = 1067865333)
    public SysConfig(Long id, String key, String value, String createTime,
            String updateTime) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Generated(hash = 1454359576)
    public SysConfig() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
