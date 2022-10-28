package cc.niushuai.project.devcontrol.base.ui;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import java.util.Map;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
import cc.niushuai.project.devcontrol.base.util.ExecUtil;
import cc.niushuai.project.devcontrol.base.util.Global;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.ToastUtil;
import cc.niushuai.project.devcontrol.base.util.UiUtil;
import cc.niushuai.project.devcontrol.ui.common.IconSelectDialogFragment;
import cc.niushuai.project.devcontrol.vo.DeviceInfo;
import cn.hutool.core.util.StrUtil;

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
     * 设置title
     *
     * @author niushuai
     * @date: 2022/10/20 10:13
     */
    protected void setTitle(String title, String subTitle) {
        this.setTitle(null, title, subTitle, null);
    }

    /**
     * 设置title 同时修改icon
     *
     * @author niushuai
     * @date: 2022/10/20 10:13
     */
    protected void setTitle(Integer backIconResId, String title, String subTitle, Integer moreSetIconResId) {
        // 标题名称
        TextView titleTextView = findViewById(R.id.activity_title_name);
        if (StrUtil.isNotEmpty(title)) {
            titleTextView.setText(title);
        }

        // 副标题名称
        TextView descTextView = findViewById(R.id.activity_title_description);
        if (StrUtil.isNotEmpty(subTitle)) {
            descTextView.setText(subTitle);
        } else {
            // 不显示副标题
            descTextView.setVisibility(View.GONE);

            // 主标题 修改高度为50dp
            titleTextView.getLayoutParams().height = UiUtil.dip2px(this, 50);
        }

        // 修改back按钮的图片
        if (null != backIconResId) {
            AppCompatImageButton btnBack = findViewById(R.id.activity_title_back);
            btnBack.setImageResource(backIconResId);
        }

        // 修改back按钮的图片
        if (null != moreSetIconResId) {
            AppCompatImageButton btnMoreSet = findViewById(R.id.activity_title_more_set);
            btnMoreSet.setImageResource(moreSetIconResId);
        }
    }

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
     * 自定义back的点击事件
     *
     * @param onClickListener 点击事件
     * @author niushuai
     * @date: 2022/10/21 14:19
     */
    protected void activityButtonBackClickListener(View.OnClickListener onClickListener) {
        findViewById(R.id.activity_title_back).setOnClickListener(onClickListener);
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
    protected void activityButtonMoreSetClickListener(boolean display, BaseActivity activity, Class<? extends BaseActivity> clazz, Map<String, String> withData) {

        View moreSetView = findViewById(R.id.activity_title_more_set);
        if (!display) {
            moreSetView.setVisibility(View.GONE);
            return;
        }
        moreSetView.setOnClickListener(view -> ActivityUtil.startActivity(activity, clazz, withData));
    }

    /**
     * 自定义moreSet点击事件
     *
     * @param onClickListener 点击事件
     * @author niushuai
     * @date: 2022/10/21 14:18
     */
    protected void activityButtonMoreSetClickListener(View.OnClickListener onClickListener) {
        findViewById(R.id.activity_title_more_set).setOnClickListener(onClickListener);
    }

    /**
     * 为icon选择绑定点击事件
     *
     * @author niushuai
     * @date: 2022/10/25 16:55
     */
    protected void activityIconSelectClickListener(Integer callbackIconResId) {
        findViewById(R.id.device_add_select_icon).setOnClickListener(view -> {
            IconSelectDialogFragment iconSelectDialogFragment = new IconSelectDialogFragment(callbackIconResId);
            iconSelectDialogFragment.show(getSupportFragmentManager(), IconSelectDialogFragment.class.getName());
        });
    }


    /**
     * 为icon选择绑定点击事件
     *
     * @param onClickListener
     * @author niushuai
     * @date: 2022/10/25 16:55
     */
    protected void activityIconSelectClickListener(View.OnClickListener onClickListener) {
        findViewById(R.id.device_add_select_icon).setOnClickListener(onClickListener);
    }

    /**
     * 重建缓存
     *
     * @author niushuai
     * @date: 2022/10/24 17:09
     */
    protected void rebuildDeviceInfoMapCache() {
        Global.initDeviceInfoMap();
    }


    /**
     * 执行命令 返回成功与否
     *
     * @param command
     * @author niushuai233
     * @date: 2022/10/28 14:00
     * @return: {@link boolean}
     */
    protected boolean exec(String command) {
        ExecUtil.CommandResult<String> commandResult = ExecUtil.exec4Str(command);
        if (commandResult.getSuccess()) {
            // 命令执行成功
            ToastUtil.show(this, "执行成功");
            return true;
        } else {
            // 命令执行失败
            ToastUtil.show(this, "执行失败, 详情请在日志中查看." + commandResult.getResult());
            return false;
        }
    }
}
