package cc.niushuai.project.devcontrol.ui.deviceadd;


import android.os.Bundle;

import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.databinding.ActivityDeviceAddPowerSwitchBinding;

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

    }
}