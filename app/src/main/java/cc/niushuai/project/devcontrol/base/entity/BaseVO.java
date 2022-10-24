package cc.niushuai.project.devcontrol.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * vo基类
 *
 * @author niushuai233
 * @date 2022/10/24 15:58
 */
public class BaseVO implements Serializable {

    private static final long serialVersionUID = 6464433262287575127L;

    private String id;

    private Integer isDeleted;

    private String remark;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
