package cc.niushuai.project.devcontrol.ui.deviceadd;


import android.os.Bundle;
import android.view.View;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.enums.DeviceTypeEnum;
import cc.niushuai.project.devcontrol.base.enums.OnOffEnum;
import cc.niushuai.project.devcontrol.base.enums.YesNoEnum;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
import cc.niushuai.project.devcontrol.base.util.CommonUiUtil;
import cc.niushuai.project.devcontrol.base.util.IdWorker;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.ToastUtil;
import cc.niushuai.project.devcontrol.databinding.ActivityDeviceAddPowerSwitchBinding;
import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.entity.Device;
import cc.niushuai.project.devcontrol.ui.powerswitch.PowerSwitchActivity;
import cn.hutool.core.date.DateUtil;
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
        // icon选择器点击事件
        this.activityIconSelectClickListener(R.id.device_add_select_icon);
    }

    /**
     * 保存设备数据
     *
     * @param view
     * @author niushuai
     * @date: 2022/10/21 14:20
     */
    private void confirm4SaveDataClickListener(View view) {
        Device device = CommonUiUtil.getDeviceInfo(this, IdWorker.getNextId());

//        device.setIconId(R.drawable.ic_device_type_switch);
        device.setDeviceType(DeviceTypeEnum.Power_Switch.getValue());
        device.setOnOff(OnOffEnum.OFF.getValue());

        device.setCreateTime(DateUtil.now());
        device.setUpdateTime(DateUtil.now());
        device.setOrder(1);
        device.setIsDeleted(YesNoEnum.NO.getIntegerValue());

        // 新增到数据库
        DB.getDeviceDao().insert(device);

        // 重建缓存
        super.rebuildDeviceInfoMapCache();

        ToastUtil.show(this, StrUtil.format("设备: {} 已新增", device.getDeviceName()));

        this.finish();
        ActivityUtil.startActivity(this, PowerSwitchActivity.class, new String[]{Keys.ID}, new String[]{device.getId() + ""});
    }


}