package cc.niushuai.project.devcontrol.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.activity.BaseActivity;
import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.enums.OnOffEnum;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.databinding.DeviceActivityBinding;

public class DeviceActivity extends BaseActivity {

    private DeviceActivityBinding binding;
    private DeviceInfo device;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏自带的标题栏
        getSupportActionBar().hide();

        binding = DeviceActivityBinding.inflate(getLayoutInflater());
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
    public void init() {
        String deviceId = getIntent().getStringExtra(Keys.ID);

        DeviceInfo data = GlobalVariables.DEVICE_INFO_MAP.get(deviceId);
        if (null != data) {
            this.device = data;
            // 标题名称
            TextView titleTextView = findViewById(R.id.device_activity_title_name);
            titleTextView.setText(device.getName());

            // 副标题名称
            TextView descTextView = findViewById(R.id.device_activity_title_description);
            descTextView.setText(device.getDescription());

            // 开关底部的名称
            TextView contentTextTextView = findViewById(R.id.device_activity_content_text);
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

        binding.deviceActivityContentSwitch.setOnClickListener(this::switchClickListener);
    }

    /**
     * 开关点击事件处理
     *
     * @param view 开关view
     * @author niushuai
     * @date: 2022/10/19 11:52
     */
    private void switchClickListener(View view) {
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
        ((AppCompatImageView) findViewById(R.id.device_activity_content_icon)).setImageResource(iconImageId);
    }


}
