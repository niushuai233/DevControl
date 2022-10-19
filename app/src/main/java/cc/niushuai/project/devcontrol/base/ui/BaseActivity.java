package cc.niushuai.project.devcontrol.base.ui;

import androidx.appcompat.app.AppCompatActivity;

import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.util.Keys;

/**
 * Activity基类
 *
 * @author niushuai
 * @date: 2022/10/18 14:24
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected DeviceInfo device;

    protected String getIntentDeviceId() {
        return getIntent().getStringExtra(Keys.ID);
    }
    /**
     * 初始化方法
     *
     * @author niushuai
     * @date: 2022/10/19 15:54
     */
    public abstract void init();
}
