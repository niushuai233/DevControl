package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import java.util.HashMap;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.enums.OnOffEnum;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.ExecUtil;
import cc.niushuai.project.devcontrol.base.util.Global;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.ToastUtil;
import cc.niushuai.project.devcontrol.base.util.XLog;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchBinding;
import cc.niushuai.project.devcontrol.db.util.DBHelper;

public class PowerSwitchActivity extends BaseActivity {

    private ActivityPowerSwitchBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPowerSwitchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化页面数据
        init();
        // 添加点击事件
        addListener();
    }

    /**
     * 初始化页面数据
     *
     * @author niushuai
     * @date: 2022/10/19 11:18
     */
    @Override
    protected void init() {

        this.device = Global.getDeviceInfo(getIntentDeviceId());
        // 标题名称
        super.setTitle(this.device.getDeviceName(), this.device.getRemark());
        // 开关底部的名称
        TextView contentTextTextView = findViewById(R.id.power_switch_activity_content_text);
        contentTextTextView.setText(device.getDeviceName());
    }

    /**
     * 添加点击事件
     *
     * @author niushuai
     * @date: 2022/10/19 11:49
     */
    @Override
    protected void addListener() {
        // 开关点击事件
        binding.powerSwitchActivityContentSwitch.setOnClickListener(this::imageSwitchClickListener);

        // 标题栏 返回
        super.activityButtonBackClickListener(this);

        // 标题栏 更多设置
        HashMap<String, String> withData = new HashMap<>(1);
        withData.put(Keys.ID, device.getId());
        super.activityButtonMoreSetClickListener(true, this, PowerSwitchSetActivity.class, withData);
    }


    /**
     * 开关点击事件处理
     *
     * @param view 开关view
     * @author niushuai
     * @date: 2022/10/19 11:52
     */
    private void imageSwitchClickListener(View view) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) view;

        int switchImageId, iconImageId;
        // 命令执行结果标识
        boolean execFlag;
        if (OnOffEnum.OFF.equals(device.getOnOff())) {
            device.setOnOff(OnOffEnum.ON);
            switchImageId = R.drawable.img_switch_open;
            iconImageId = R.drawable.ic_device_light_1_on;

            execFlag = switchOn();
        } else {
            device.setOnOff(OnOffEnum.OFF);
            switchImageId = R.drawable.img_switch_close;
            iconImageId = R.drawable.ic_device_light_1_close;

            execFlag = switchOff();
        }
        if (execFlag) {
            // 执行成功 设置icon
            appCompatImageView.setImageResource(switchImageId);
            ((AppCompatImageView) findViewById(R.id.power_switch_activity_content_icon)).setImageResource(iconImageId);

            // 写入数据库
            DBHelper.deviceUpdate(device);
        }
    }

    /**
     * 执行开关开启命令
     *
     * @author niushuai233
     * @date: 2022/10/28 13:35
     */
    private boolean switchOn() {
        String command = Global.getDeviceCommandOpen(device);
        XLog.i(Keys.Tag.EXEC_COMMAND, "设备: {}, 命令: {}", device.getDeviceName(), command);

        return exec(command);
    }


    /**
     * 执行开关关闭命令
     *
     * @author niushuai233
     * @date: 2022/10/28 13:35
     */
    private boolean switchOff() {
        String command = Global.getDeviceCommandClose(device);
        XLog.i(Keys.Tag.EXEC_COMMAND, "设备: {}, 命令: {}", device.getDeviceName(), command);

        return exec(command);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
