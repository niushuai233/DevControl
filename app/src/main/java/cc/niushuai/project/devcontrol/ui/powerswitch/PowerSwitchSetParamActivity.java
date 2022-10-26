package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.CommonUiUtil;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchSetParamBinding;
import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.vo.DeviceInfo;

public class PowerSwitchSetParamActivity extends BaseActivity {

    private ActivityPowerSwitchSetParamBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPowerSwitchSetParamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.init();
        this.addListener();
    }

    @Override
    protected void init() {
        device = GlobalVariables.getDeviceInfo(getIntentDeviceId());

        this.setTitle(null, getString(R.string.power_switch_set_paramSet), null, R.drawable.ic_confrim_32);

        // 回显数据
        CommonUiUtil.echoDeviceInfo(this, device);

    }


    @Override
    protected void addListener() {

        // 隐藏更多按钮
        super.activityButtonBackClickListener(this);
        // 保存监听事件
        super.activityButtonMoreSetClickListener(this::btnUpdateParamClickListener);
        // icon选择监听事件
        super.activityIconSelectClickListener(R.id.device_add_select_icon);
    }

    /**
     * 更新数据操作
     *
     * @param view
     * @author niushuai
     * @date: 2022/10/25 13:56
     */
    private void btnUpdateParamClickListener(View view) {
        // 构建更新数据
        DeviceInfo deviceInfo = CommonUiUtil.getDeviceInfo(this, device.getId());
        deviceInfo.setDeviceType(device.getDeviceType());
        deviceInfo.setOnOff(device.getOnOff());
        deviceInfo.setOrder(device.getOrder());
//        deviceInfo.setIconId(device.getIconId());
        deviceInfo.setIsDeleted(device.getIsDeleted());
        deviceInfo.setCreateTime(device.getCreateTime());
        DB.getDeviceDao().update(deviceInfo.toDevice());

        // 对当前设备引用重新赋值
        device = deviceInfo;

        // 返回上一层
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
