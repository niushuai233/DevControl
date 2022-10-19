package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.os.Bundle;

import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchBinding;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchSetBinding;

public class PowerSwitchSetActivity extends BaseActivity {

    private ActivityPowerSwitchSetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        binding = ActivityPowerSwitchSetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void init() {
        device = GlobalVariables.getDeviceInfo(getIntentDeviceId());



    }
}