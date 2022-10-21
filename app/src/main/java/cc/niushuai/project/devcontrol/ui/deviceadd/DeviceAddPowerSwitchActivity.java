package cc.niushuai.project.devcontrol.ui.deviceadd;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.enums.DeviceTypeEnum;
import cc.niushuai.project.devcontrol.base.enums.OnOffEnum;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.ToastUtil;
import cc.niushuai.project.devcontrol.databinding.ActivityDeviceAddPowerSwitchBinding;
import cc.niushuai.project.devcontrol.ui.powerswitch.PowerSwitchActivity;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

public class DeviceAddPowerSwitchActivity extends BaseActivity {

    private ActivityDeviceAddPowerSwitchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeviceAddPowerSwitchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.init();
        this.addListener();
    }

    @Override
    protected void init() {

        // 设置标题栏信息
        this.setTitle(null, getString(R.string.power_switch_add), null, R.drawable.ic_confrim_32);


    }

    /**
     * 监听器事件统一设置入口
     *
     * @author niushuai
     * @date: 2022/10/19 17:31
     */
    @Override
    protected void addListener() {

        // 返回事件
        this.activityButtonBackClickListener(this);
        // 保存设备信息事件
        this.activityButtonMoreSetClickListener(this::confirm4SaveDataClickListener);
    }

    /**
     * 保存设备数据
     *
     * @param view
     * @author niushuai
     * @date: 2022/10/21 14:20
     */
    private void confirm4SaveDataClickListener(View view) {
        DeviceInfo device = new DeviceInfo();

        device.setId(IdUtil.nanoId());
        device.setIconId(R.drawable.ic_device_type_switch);
        device.setDeviceType(DeviceTypeEnum.Power_Switch);
        device.setOnOff(OnOffEnum.OFF);
        device.setName(binding.deviceAddName.getText().toString());
        device.setDescription("默认设备");
        device.setCommandPath(binding.deviceAddParamProgram.getText().toString());
        device.setCommandOpen(binding.deviceAddParamOpen.getText().toString());
        device.setCommandClose(binding.deviceAddParamClose.getText().toString());

        GlobalVariables.DEVICE_INFO_MAP.put(device.getId(), device);

        ToastUtil.show(this, StrUtil.format("设备: {} 已新增", device.getName()));

        this.finish();
        ActivityUtil.startActivity(this, PowerSwitchActivity.class, new String[]{Keys.ID}, new String[]{device.getId()});
    }
}