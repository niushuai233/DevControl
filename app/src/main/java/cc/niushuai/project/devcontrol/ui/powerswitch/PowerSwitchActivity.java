package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.enums.OnOffEnum;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchBinding;

public class PowerSwitchActivity extends BaseActivity {

    private ActivityPowerSwitchBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏自带的标题栏
        getSupportActionBar().hide();

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
    public void init() {

        DeviceInfo data = GlobalVariables.getDeviceInfo(getIntentDeviceId());
        if (null != data) {
            this.device = data;
            // 标题名称
            TextView titleTextView = findViewById(R.id.activity_title_name);
            titleTextView.setText(device.getName());

            // 副标题名称
            TextView descTextView = findViewById(R.id.activity_title_description);
            descTextView.setText(device.getDescription());

            // 开关底部的名称
            TextView contentTextTextView = findViewById(R.id.power_switch_activity_content_text);
            contentTextTextView.setText(device.getName());
        }
    }

    /**
     * 添加点击事件
     *
     * @author niushuai
     * @date: 2022/10/19 11:49
     */
    private void addListener() {
        // 开关点击事件
        binding.powerSwitchActivityContentSwitch.setOnClickListener(this::imageSwitchClickListener);

        // 标题栏 返回
        findViewById(R.id.activity_title_back).setOnClickListener(this::buttonBackClickListener);
//        binding.powerSwitchActivityTitleBack.setOnClickListener(this::buttonBackClickListener);

        // 标题栏 更多设置
        findViewById(R.id.activity_title_more_set).setOnClickListener(this::buttonMoreSetClickListener);
//        binding.powerSwitchActivityTitleMoreSet.setOnClickListener(this::buttonMoreSetClickListener);
    }

    /**
     * 更多设置 打开fragment
     *
     * @param view
     * @author niushuai
     * @date: 2022/10/19 14:47
     */
    private void buttonMoreSetClickListener(View view) {
//        ActivityUtil.startActivity(this, PowerSwitchSetActivity.class);

        Intent intent = new Intent(this, PowerSwitchSetActivity.class);

        startActivity(intent);

    }

    /**
     * 返回上一页
     *
     * @param view
     * @author niushuai
     * @date: 2022/10/19 14:46
     */
    private void buttonBackClickListener(View view) {
//        AppCompatImageButton buttonBack = (AppCompatImageButton) view;
        PowerSwitchActivity.this.finish();
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


}
