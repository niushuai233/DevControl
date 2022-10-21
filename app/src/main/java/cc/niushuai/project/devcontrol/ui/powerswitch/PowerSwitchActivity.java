package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import java.util.HashMap;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.enums.OnOffEnum;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchBinding;

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

        this.device = GlobalVariables.getDeviceInfo(getIntentDeviceId());
        // 标题名称
        super.setTitle(this.device.getName(), this.device.getDescription());
        // 开关底部的名称
        TextView contentTextTextView = findViewById(R.id.power_switch_activity_content_text);
        contentTextTextView.setText(device.getName());
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
        if (OnOffEnum.OFF.equals(device.getOnOff())) {
            device.setOnOff(OnOffEnum.ON);
            switchImageId = R.drawable.img_switch_open;
            iconImageId = R.drawable.ic_device_light_1_on;
        } else {
            device.setOnOff(OnOffEnum.OFF);
            switchImageId = R.drawable.img_switch_close;
            iconImageId = R.drawable.ic_device_light_1_close;
        }
        appCompatImageView.setImageResource(switchImageId);
        ((AppCompatImageView) findViewById(R.id.power_switch_activity_content_icon)).setImageResource(iconImageId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
