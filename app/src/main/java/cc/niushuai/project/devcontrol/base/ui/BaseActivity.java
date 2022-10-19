package cc.niushuai.project.devcontrol.base.ui;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
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
    protected abstract void init();

    /**
     * 监听器事件统一设置入口
     *
     * @author niushuai
     * @date: 2022/10/19 17:31
     */
    protected void addListener() {
    }

    /**
     * 返回上一页
     *
     * @param activity
     * @author niushuai
     * @date: 2022/10/19 14:46
     */
    protected void activityButtonBackClickListener(BaseActivity activity) {
        findViewById(R.id.activity_title_back).setOnClickListener(view -> activity.finish());
    }

    /**
     * 更多设置 打开新的activity
     *
     * @param activity 源activity
     * @param clazz    目标activity
     * @param withData activity之间传递数据
     * @author niushuai
     * @date: 2022/10/19 14:47
     */
    protected void activityButtonMoreSetClickListener(BaseActivity activity, Class<? extends BaseActivity> clazz, Map<String, String> withData) {
        findViewById(R.id.activity_title_more_set).setOnClickListener(view -> ActivityUtil.startActivity(activity, clazz, withData));
    }

}
